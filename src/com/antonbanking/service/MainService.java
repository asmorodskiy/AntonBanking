package com.antonbanking.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.antonbanking.business.User;
import com.antonbanking.dao.UserDAO;

public class MainService {

	public static ArrayList<User> getAllUsers() throws ClassNotFoundException, SQLException
	{		
		UserDAO db = new UserDAO();
		return db.findAll();
	}
	
	public static User getUser(int id) throws ClassNotFoundException, SQLException
	{
		UserDAO db = new UserDAO();
		return db.find(id);
	}
}
