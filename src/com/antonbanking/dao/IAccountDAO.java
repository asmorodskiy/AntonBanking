package com.antonbanking.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import com.antonbanking.business.Account;
import com.antonbanking.business.CurrencyType;


public interface IAccountDAO {
	
	public Account insert(int user_id,double quantity,CurrencyType typ) throws SQLException, ClassNotFoundException;
	
	
	
	public int update(int id,double transactionValue) throws SQLException, ClassNotFoundException;	
	
	public void delete(int id) throws SQLException ;
	
	public Account find(int id) throws SQLException, ClassNotFoundException;	
	
	public ArrayList<Integer> getAccountIDs(int user_id) throws SQLException;	
	
	public ArrayList<Account> getAllAccountsByID(int user_id) throws SQLException, ClassNotFoundException;
	
	
	public String getAccountCurrencyName(int accountId) throws SQLException, ClassNotFoundException;	

}
