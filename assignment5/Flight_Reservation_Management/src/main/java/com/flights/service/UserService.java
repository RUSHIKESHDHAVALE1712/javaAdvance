package com.flights.service;

import com.flights.dao.UserDao;
import com.flights.entity.User;

public class UserService {
	private UserDao dao=new UserDao();
	public boolean register(User user)
	{
		boolean status=false;
		if((dao.searchByMail(user.getEmail())==null))
				{
			dao.save(user);
			status= true;
				}
		else 
			throw new ResourseAlreadyExistsException("Email already Registers");
		return status;
	}
	public User login(String email,String password)
	{
		User user=null;
		user=dao.searchByEmailPass(email, password);
		return user;
	}

}
