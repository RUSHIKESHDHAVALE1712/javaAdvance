package com.flights.service;

import java.util.List;

import com.flights.dao.BookingDao;
import com.flights.entity.Booking;

public class BookingService {
	private BookingDao bookingDao;

	public BookingService() {
		bookingDao=new BookingDao();
	}
	public boolean bookFlight(int userId,int flightId)
	{
		return bookingDao.save(userId, flightId);
	}
	public List<Booking> findBooking(int uId)
	{
		return bookingDao.findBooking(uId);
	}
	public boolean cancelFlight(int bId)
	{
		return bookingDao.cancelFlight(bId);
	}

}
