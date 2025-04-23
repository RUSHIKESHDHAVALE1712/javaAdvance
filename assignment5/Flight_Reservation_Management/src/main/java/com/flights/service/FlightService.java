package com.flights.service;

import java.time.LocalDate;
import java.util.List;

import com.flights.dao.FlightDao;
import com.flights.entity.Flight;

public class FlightService {
   private FlightDao dao;
	public FlightService() {
		dao=new FlightDao();
	}
	public List<Flight> searchFlight(String source,String dest,LocalDate date)
	{
		return dao.searchFlight(source, dest, date);
	}

}
