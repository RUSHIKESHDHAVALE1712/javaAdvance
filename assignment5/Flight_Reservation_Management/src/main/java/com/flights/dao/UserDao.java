package com.flights.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;

import com.flights.entity.User;
import com.flights.utility.AutoConnect;

public class UserDao {
  private String query;
	public UserDao(){
		
	}
	public boolean save(User user) {
	    query = "insert into user (user_name, user_email, user_password) values (?, ?, ?)";
	    boolean status = false;

	    try (Connection con = AutoConnect.autoConnect();
	         PreparedStatement pstmt = con.prepareStatement(query)) {
	        
	        
	        pstmt.setString(1, user.getName());
	        pstmt.setString(2, user.getEmail());
	        pstmt.setString(3, user.getPassword());
	        
	        int updates = pstmt.executeUpdate();
	        
	        if (updates > 0) {
	            status = true;
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    
	    return status;
	}

	public Collection<User> viewAll()
	{
		query="select * from user;";
		Collection<User> users=new ArrayList<User>();
		try(Connection con=AutoConnect.autoConnect();
			Statement stmt=con.createStatement()
			)
		{
			ResultSet rs=stmt.executeQuery(query);
			while(rs.next())
			{
				User user=new User(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4));
			     users.add(user);
			}
		
	}
		catch(Exception e)
		{
			
		}
	
return users;
}
	public User searchByMail(String email)
	{
		User user=null;
		query="select * from user where user_email=?";
		
		try(Connection con=AutoConnect.autoConnect();
			PreparedStatement pstmt=con.prepareStatement(query);
			)
		{
			pstmt.setString(1, email);
			ResultSet rs=pstmt.executeQuery();
		    while(rs.next())
		    {
		     user=new User(rs.getInt(1),rs.getString(1),rs.getString(2),rs.getString(3));
		    }
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return user;
	}
	public User searchById(int id)
	{
		User user=null;
		query="select * from user where user_id=?";
		
		try(Connection con=AutoConnect.autoConnect();
			PreparedStatement pstmt=con.prepareStatement(query);
			)
		{
			pstmt.setInt(1, id);
			ResultSet rs=pstmt.executeQuery();
		    while(rs.next())
		    {
		     user=new User(rs.getInt(1),rs.getString(1),rs.getString(2),rs.getString(3));
		    }
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return user;
	}
	public User searchByEmailPass(String email,String pass)
	{
		User user=null;
		query="select * from user where user_email=? and user_password=?";
		
		try(Connection con=AutoConnect.autoConnect();
			PreparedStatement pstmt=con.prepareStatement(query);
			)
		{
			pstmt.setString(1, email);
			pstmt.setString(2, pass);
			ResultSet rs=pstmt.executeQuery();
		    while(rs.next())
		    {
		     user=new User(rs.getInt(1),rs.getString(1),rs.getString(2),rs.getString(3));
		    }
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return user;
	}
	
}