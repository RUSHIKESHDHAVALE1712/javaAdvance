package com.flights.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.flights.entity.Flight;
import com.flights.utility.AutoConnect;

public class FlightDao {
private String query;
 List<Flight> flights=new ArrayList<Flight>();
	public List<Flight> searchFlight(String source,String dest,LocalDate date)
	{
		query="select * from flight where source=? and destination=? and flight_date=?";
		try(Connection con=AutoConnect.autoConnect();
				PreparedStatement pstmt=con.prepareStatement(query)) {
			pstmt.setString(1, source);
			pstmt.setString(2, dest);
			pstmt.setDate(3, Date.valueOf(date));
			ResultSet rs= pstmt.executeQuery();
			while(rs.next())
			{
				flights.add(new Flight(rs.getInt(1), rs.getString(2),rs.getString(3),rs.getString(4), 
						rs.getDate(5).toLocalDate(),rs.getDouble(6)));
				
			}
			
			
			
		} catch (Exception e) {
			e.getMessage();
		}
		return flights;
		
	}
}
