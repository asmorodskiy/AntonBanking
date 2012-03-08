package com.antonbanking.service;

import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;

import com.antonbanking.business.Account;
import com.antonbanking.business.CurrencyType;
import com.antonbanking.business.MyTransaction;
import com.antonbanking.business.User;
import com.antonbanking.hibernate.AccountDB;
import com.antonbanking.hibernate.UserDB;

public class MainService {

    @Autowired
    private UserDB userDB;

    public static ArrayList<User> getAllUsers() throws ClassNotFoundException,
	    SQLException {
	return userDB.findAll();
    }

    public static ArrayList<Account> getAllAccounts(int userID) {
	UserDB db = new UserDB();
	return db.getAllAccountsByID(userID);
    }

    public static ArrayList<MyTransaction> getAllMyTransactions(int account_id) {
	AccountDB db = new AccountDB();
	return db.getAllMyTransactionsByID(account_id);
    }

    public static boolean AddUser(String username) {
	UserDB db = new UserDB();
	User user = new User();
	user.setName(username);
	db.insert(user);
	return true;
    }

    public static boolean AddAccount(String userID, String typ, String qantity) {
	UserDB db = new UserDB();
	User user = db.find(Integer.valueOf(userID));
	Account account = new Account(CurrencyType.valueOf(typ));
	account.setQuantity(Double.valueOf(qantity));
	user.addAccount(account);
	db.update(user);
	return true;
    }

    public static String getUserName(int id) {
	UserDB db = new UserDB();
	return db.find(id).getName();
    }

    public static String getAccountCurrencyName(int account_id) {
	AccountDB db = new AccountDB();
	return db.getAccountCurrencyName(account_id);
    }

    public static boolean AddTransaction(String account_id, double value) {
	AccountDB account_db = new AccountDB();
	int id = Integer.valueOf(account_id);
	Account account = account_db.find(id);
	MyTransaction transaction = new MyTransaction(value);
	account.addTransaction(transaction);
	account_db.update(account);
	return true;
    }
}
