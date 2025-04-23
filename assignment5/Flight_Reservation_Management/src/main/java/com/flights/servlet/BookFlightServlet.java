package com.flights.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import com.flights.entity.Booking;
import com.flights.service.BookingService;

/**
 * Servlet implementation class BookFlightServlet
 */
@WebServlet("/bookFlight")
public class BookFlightServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookFlightServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		HttpSession session=request.getSession();
		int flightId=Integer.valueOf(request.getParameter("flightId"));
		int userId=(Integer)session.getAttribute("userId");
		boolean isBooked=new BookingService().bookFlight(userId, flightId);
		if(isBooked)
		{
			out.println("<h2>Flight Booked Successfully</h2>");
			List<Booking> bookings=new BookingService().findBooking(userId);
			RequestDispatcher dispatcher=request.getRequestDispatcher("showBooking.jsp");
			request.setAttribute("booking",bookings);
			dispatcher.include(request, response);
		}
		else
		{
			out.println("<h2>Failed To Book Please Try Again!!</h2>");
		}
		
	}

}
