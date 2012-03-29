package com.antonbanking.service;

import java.util.ArrayList;
import java.util.Set;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.antonbanking.business.Account;
import com.antonbanking.business.MyTransaction;
import com.antonbanking.business.User;
import com.antonbanking.hibernate.AccountDB;
import com.antonbanking.hibernate.UserDB;

@Transactional(propagation = Propagation.SUPPORTS, readOnly = false)
public class MainService
{
    public static UserDB userDB = new UserDB();

    public static AccountDB accountDB = new AccountDB();

    public static ArrayList<User> getAllUsers()
    {
        return userDB.findAll();
    }

    public static Set<Account> getAllAccounts(int userID)
    {
        return userDB.getAllAccountsByID(userID);
    }

    public static Set<MyTransaction> getAllMyTransactions(int account_id)
    {
        return accountDB.getAllMyTransactionsByID(account_id);
    }

    public static boolean AddUser(User user)
    {
        userDB.insert(user);
        return true;
    }

    public static boolean AddAccount(String userID, Account account)
    {
        User user = userDB.find(Integer.valueOf(userID));
        user.addAccount(account);
        userDB.update(user);
        return true;
    }

    public static String getUserName(int id)
    {
        return userDB.find(id).getName();
    }

    public static String getAccountCurrencyName(int account_id)
    {
        return accountDB.getAccountCurrencyName(account_id);
    }

    public static boolean updateAccount(int accountID, MyTransaction transaction)
    {
        Account account = accountDB.find(accountID);
        account.addTransaction(transaction);
        accountDB.update(account);
        return true;
    }
}
