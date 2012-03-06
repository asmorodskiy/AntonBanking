package com.antonbanking.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.antonbanking.business.Account;
import com.antonbanking.business.CurrencyType;
import com.antonbanking.business.MyTransaction;
import com.antonbanking.business.User;
import com.antonbanking.hibernate.AccountDB;
import com.antonbanking.hibernate.UserDB;

public class MainService {

    public static ArrayList<User> getAllUsers() throws ClassNotFoundException,
	    SQLException {
	UserDB db = new UserDB();
	return db.findAll();
    }

    public static ArrayList<Account> getAllAccounts(int userID) {
	UserDB db;
	try {
	    db = new UserDB();
	    return db.getAllAccountsByID(userID);
	} catch (ClassNotFoundException e) {
	    e.printStackTrace();
	    return null;
	} catch (SQLException e) {
	    e.printStackTrace();
	    return null;
	}

    }

    public static ArrayList<MyTransaction> getAllMyTransactions(int account_id) {
	AccountDB db;
	try {
	    db = new AccountDB();
	    return db.getAllMyTransactionsByID(account_id);
	} catch (SQLException e) {
	    e.printStackTrace();
	    return null;
	}

    }

    public static boolean AddUser(String username) {
	UserDB db;
	try {
	    db = new UserDB();
	    User user = new User();
	    user.setName(username);
	    db.insert(user);
	    return true;
	} catch (SQLException e) {
	    e.printStackTrace();
	    return false;
	}

    }

    public static boolean AddAccount(String userID, String typ, String qantity) {
	UserDB db;
	try {
	    db = new UserDB();
	    User user = db.find(Integer.valueOf(userID));
	    Account account = new Account(CurrencyType.valueOf(typ));
	    account.setQuantity(Double.valueOf(qantity));
	    user.addAccount(account);
	    db.update(user);
	    return true;
	} catch (ClassNotFoundException e) {
	    e.printStackTrace();
	    return false;
	} catch (SQLException e) {
	    e.printStackTrace();
	    return false;
	}
    }

    public static String getUserName(int id) {
	UserDB db;
	try {
	    db = new UserDB();
	    return db.find(id).getName();
	} catch (ClassNotFoundException e) {
	    e.printStackTrace();
	    return null;
	} catch (SQLException e) {
	    e.printStackTrace();
	    return null;
	}
    }

    public static String getAccountCurrencyName(int account_id) {
	AccountDB db;
	try {
	    db = new AccountDB();
	    return db.getAccountCurrencyName(account_id);
	} catch (ClassNotFoundException e) {
	    e.printStackTrace();
	    return null;
	} catch (SQLException e) {
	    e.printStackTrace();
	    return null;
	}
    }

    public static boolean AddTransaction(String account_id, double value) {
	AccountDB account_db;
	try {
	    int id = Integer.valueOf(account_id);
	    account_db = new AccountDB();
	    Account account = account_db.find(id);
	    MyTransaction transaction = new MyTransaction(value);
	    account.addTransaction(transaction);
	    account_db.update(account);
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
