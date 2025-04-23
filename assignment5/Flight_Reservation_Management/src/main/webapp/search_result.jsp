<%@page import="com.flights.entity.Flight"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Available Flights</title>
</head>
<body>
<h2>✈️Available Flights✈️</h2>

<%
    List<Flight> flights = (List<Flight>) request.getAttribute("flights");
    
        for (Flight f : flights) {
%>
<p>
    Flight Number: <%= f.getFlightNumber() %> |
    <%= f.getSource() %> → <%= f.getDestination() %><br>
    Schedule Date: <%= f.getFlightDate() %> |
    Price: <%= f.getPrice() %>
    
    <form action="bookFlight" method="post" >
    <input type="Hidden" name="flightId" value=<%=f.getId() %>>
    <button>Book</button>
    
    </form>
</p>
<hr>
<%
        }
   %>
</body>
</html>
