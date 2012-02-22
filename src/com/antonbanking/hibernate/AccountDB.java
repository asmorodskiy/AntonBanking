package com.antonbanking.hibernate;

import java.sql.SQLException;
import java.util.ArrayList;

import com.antonbanking.business.Account;
import com.antonbanking.business.CurrencyType;
import com.antonbanking.dao.IAccountDAO;

public class AccountDB implements IAccountDAO {

	@Override
	public Account insert(int user_id, double quantity, CurrencyType typ)
			throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int update(int id, double transactionValue) throws SQLException,
			ClassNotFoundException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void delete(int id) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public Account find(int id) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Integer> getAccountIDs(int user_id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Account> getAllAccountsByID(int user_id)
			throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getAccountCurrencyName(int accountId) throws SQLException,
			ClassNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

}
