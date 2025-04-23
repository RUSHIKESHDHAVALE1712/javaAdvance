package com.flights.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.flights.entity.Booking;
import com.flights.utility.AutoConnect;

public class BookingDao {
private String query;
boolean status=false;
	public boolean save(int userId,int flightId)
	{ query="insert into booking(user_id,flight_id) values(?,?)";
		try(Connection con=AutoConnect.autoConnect();
			PreparedStatement pstmt=con.prepareStatement(query)){
			pstmt.setInt(2, flightId);
			pstmt.setInt(1,userId);
			int count=pstmt.executeUpdate();
			if(count>0)
			{
				System.out.println(count+" row inserted");
				status=true;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}
	public List<Booking> findBooking(int uId)
	{
		List<Booking> bookings=new ArrayList<>();
		{ query="select * from booking where  user_id=?";
		try(Connection con=AutoConnect.autoConnect();
			PreparedStatement pstmt=con.prepareStatement(query)){
			pstmt.setInt(1, uId);
			 ResultSet rs= pstmt.executeQuery();
			 while(rs.next())
			 {
				bookings.add( new Booking(rs.getInt(1),rs.getInt(2),
						 rs.getInt(3),(rs.getDate(4)).toLocalDate()));
			 }
			 
		
	}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		

}
		return bookings;
}
	public boolean cancelFlight(int bId)
	{
		boolean status=false;
		{ query="delete from booking where id=?";
		try(Connection con=AutoConnect.autoConnect();
			PreparedStatement pstmt=con.prepareStatement(query)){
			pstmt.setInt(1, bId);
			int updates=pstmt.executeUpdate();
			if(updates>0)
			{
				status=true;
			}
			
	}
		catch(Exception e)
		{
			e.printStackTrace();
		}
}
		return status;
	}
}