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
	
	public static ArrayList<Account> getAllAccounts(int userID)
	{		
		AccountDAO db;
		try {
			db = new AccountDAO();
			return db.getAllAccountsByID(userID);
		} catch (ClassNotFoundException e) {			
			e.printStackTrace();
			return null;
		} catch (SQLException e) {			
			e.printStackTrace();
			return null;
		}
		
	}
	
	public static ArrayList<MyTransaction> getAllMyTransactions(int account_id) 
	{
		MyTransactionDAO db;
		try {
			db = new MyTransactionDAO();
			return db.getAllMyTransactionsByID(account_id);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		} catch (SQLException e) {			
			e.printStackTrace();
			return null;
		}
		
	}
	
	public static boolean AddUser(String username)
	{
		UserDAO db;
		try {
			db = new UserDAO();
			db.insert(username);
			return true;
		} catch (ClassNotFoundException e) {			
			e.printStackTrace();
			return false;
		} catch (SQLException e) {			
			e.printStackTrace();
			return false;
		}
		
	}
	
	public static boolean AddAccount(String userID,String typ,String qantity) 
	{
		AccountDAO db;
		try {
			db = new AccountDAO();
			db.insert(Integer.valueOf(userID),Double.valueOf(qantity),CurrencyType.valueOf(typ));
			return true;
		} catch (ClassNotFoundException e) {			
			e.printStackTrace();
			return false;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		
	}	
	 
	public static String getUserName(int id)
	{
		UserDAO db;
		try {
			db = new UserDAO();
			return db.find(id).getName();
		} catch (ClassNotFoundException e) {			
			e.printStackTrace();
			return null;
		} catch (SQLException e) {			
			e.printStackTrace();
			return null;
		}
		
	}
	
	public static String getAccountCurrencyName(int account_id)
	{
		AccountDAO db;
		try {
			db = new AccountDAO();
			return db.getAccountCurrencyName(account_id);
		} catch (ClassNotFoundException e) {			
			e.printStackTrace();
			return null;
		} catch (SQLException e) {			
			e.printStackTrace();
			return null;
		}
		
	}
	
	public static boolean AddTransaction(String account_id,double value)
	{
		MyTransactionDAO db;
		try {
			db = new MyTransactionDAO();
			db.insert(Integer.valueOf(account_id),value);
			return true;
		} catch (ClassNotFoundException e) {			
			e.printStackTrace();
			return false;
		} catch (SQLException e) {			
			e.printStackTrace();
			return false;
		}
		
	}
}
