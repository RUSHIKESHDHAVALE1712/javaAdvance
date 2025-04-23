package javaproject;
//this is a utility class used for obtaining a connection.

import java.sql.Connection;
import java.sql.DriverManager;

public class jdbcUtils 
{
	public static Connection buildConnection() throws Exception
	{
		//class.froName() is not required because the driver gets loaded Automatically.
		//once its JAR file is found in project's build path.
		
		String connectionUr1 = "jdbc:mysql://localhost:3306/cdac";
		String userName = "root";
		String password = "password";
		Connection	dbConnection = 
				DriverManager.getConnection(connectionUr1,userName,password);
		System.out.println("Connection Established");
		return dbConnection;
		 
	}
	public static void main(String[] args) 
	{
		try 
		{
			buildConnection();
			System.out.println("Got the connection...!!!!!!");
		} catch (Exception e) 
		{
			e.printStackTrace();
		}
		
	}
}
