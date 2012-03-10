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

    public static ArrayList<User> getAllUsers(UserDB userDB) throws ClassNotFoundException,
	    SQLException {
	return userDB.findAll();
    }

    public static ArrayList<Account> getAllAccounts(int userID,UserDB userDB) {	
        return userDB.getAllAccountsByID(userID);
    }

    public static ArrayList<MyTransaction> getAllMyTransactions(int account_id,AccountDB accountDB) {	
	return accountDB.getAllMyTransactionsByID(account_id);
    }

    public static boolean AddUser(String username,UserDB userDB) {	
	User user = new User();
	user.setName(username);
	userDB.insert(user);
	return true;
    }

    public static boolean AddAccount(String userID, String typ, String qantity,UserDB userDB) {	
	User user = userDB.find(Integer.valueOf(userID));
	Account account = new Account(CurrencyType.valueOf(typ));
	account.setQuantity(Double.valueOf(qantity));
	user.addAccount(account);
	userDB.update(user);
	return true;
    }

    public static String getUserName(int id,UserDB userDB) {	
	return userDB.find(id).getName();
    }

    public static String getAccountCurrencyName(int account_id,AccountDB accountDB) {	
	return accountDB.getAccountCurrencyName(account_id);
    }

    public static boolean AddTransaction(String account_id, double value,AccountDB accountDB) {	
	int id = Integer.valueOf(account_id);
	Account account = accountDB.find(id);
	MyTransaction transaction = new MyTransaction(value);
	account.addTransaction(transaction);
	accountDB.update(account);
	return true;
    }
}
