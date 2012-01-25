package com.antonbanking.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.antonbanking.business.Account;
import com.antonbanking.business.CurrencyType;
import com.antonbanking.business.MyTransaction;
import com.antonbanking.business.User;
import com.antonbanking.dao.AccountDAO;
import com.antonbanking.dao.MyTransactionDAO;
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
	
	public static ArrayList<MyTransaction> getAllMyTransactions(int account_id) throws ClassNotFoundException, SQLException
	{
		MyTransactionDAO db = new MyTransactionDAO();
		return db.getAllMyTransactionsByID(account_id);
	}
	
	public static void AddUser(String username) throws ClassNotFoundException, SQLException
	{
		UserDAO db = new UserDAO();
		db.insert(username);
	}
	
	public static void AddAccount(String userID,String typ,String qantity) throws ClassNotFoundException, SQLException
	{
		AccountDAO db = new AccountDAO();
		db.insert(Integer.valueOf(userID),Double.valueOf(qantity),CurrencyType.valueOf(typ));
	}	
	 
	public static String getUserName(int id) throws ClassNotFoundException, SQLException
	{
		UserDAO db = new UserDAO();
		return db.find(id).getName();
	}
	
}
