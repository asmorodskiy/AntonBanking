package com.antonbanking.hibernate;

import java.sql.SQLException;
import java.util.ArrayList;

import com.antonbanking.business.Account;
import com.antonbanking.business.MyTransaction;

public class AccountDB {

    public void insert(Account account) {
    }

    public void update(Account account) throws SQLException,
	    ClassNotFoundException {
    }

    public void delete(Account account) throws SQLException {
	// TODO Auto-generated method stub

    }

    public Account find(int account_id) throws SQLException,
	    ClassNotFoundException {
	// TODO Auto-generated method stub
	return null;
    }

    public ArrayList<MyTransaction> getAllMyTransactionsByID(int account_id)
	    throws SQLException {
	// TODO Auto-generated method stub
	return null;
    }

    public ArrayList<Integer> getAccountIDs(int user_id) throws SQLException {
	// TODO Auto-generated method stub
	return null;
    }

    public String getAccountCurrencyName(int accountId) throws SQLException,
	    ClassNotFoundException {
	// TODO Auto-generated method stub
	return null;
    }

}
