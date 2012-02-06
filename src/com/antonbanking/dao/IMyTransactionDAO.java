package com.antonbanking.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import com.antonbanking.business.MyTransaction;

public interface IMyTransactionDAO {
	
	public MyTransaction insert(int account_id,double val) throws SQLException;
	
	
	public void delete(int trans_id) throws SQLException;
	
	
	public MyTransaction find(int trans_id) throws SQLException;
	
	
	public ArrayList<Integer> getMyTransactionIDs(int acc_id) throws SQLException;
	

	public ArrayList<MyTransaction> getAllMyTransactionsByID(int account_id) throws SQLException;
	

}
