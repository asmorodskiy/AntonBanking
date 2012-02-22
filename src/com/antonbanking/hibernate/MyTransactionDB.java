package com.antonbanking.hibernate;

import java.sql.SQLException;
import java.util.ArrayList;

import com.antonbanking.business.MyTransaction;
import com.antonbanking.dao.IMyTransactionDAO;

public class MyTransactionDB implements IMyTransactionDAO {

	@Override
	public MyTransaction insert(int account_id, double val) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(int trans_id) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public MyTransaction find(int trans_id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Integer> getMyTransactionIDs(int acc_id)
			throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<MyTransaction> getAllMyTransactionsByID(int account_id)
			throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
