package com.flights.dao;

import java.util.ArrayList;
import java.util.Collection;

import com.flights.entity.User;

public class UserMain {

	public static void main(String[] args) {
		UserDao dao=new UserDao();
		/*User user =new User(0,"Bhakti","bhakti@gmail.com","Bhakti");
		System.out.println(dao.save(user));
		Collection<User> u=dao.viewAll();
		System.out.println(u);
		User us=dao.searchByMail("bhakti@gmail.com");
		System.out.println(us);*/
		//System.out.println(dao.searchById(5));
		System.out.println(dao.searchByEmailPass("bhakti@gmail.com","Bhakti"));
	}

}
