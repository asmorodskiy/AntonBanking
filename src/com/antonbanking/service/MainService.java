package com.antonbanking.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.antonbanking.business.Account;
import com.antonbanking.business.User;
import com.antonbanking.dao.AccountDAO;
import com.antonbanking.dao.UserDAO;

public class MainService {

	public static ArrayList<User> getAllUsers() throws ClassNotFoundException, SQLException
	{		
		UserDAO db = new UserDAO();
		return db.findAll();
	}
	
	public static ArrayList<Account> getAllAccounts(int userID) throws ClassNotFoundException, SQLException
	{		
		AccountDAO db = new AccountDAO();
		return db.getAllAccountsByID(userID);
	}
	
	public static void AddUser(String username) throws ClassNotFoundException, SQLException
	{
		UserDAO db = new UserDAO();
		db.insert(username);
	}
	
	
	
	////// 
	public static User getUser(int id) throws ClassNotFoundException, SQLException
	{
		UserDAO db = new UserDAO();
		return db.find(id);
	}
}
