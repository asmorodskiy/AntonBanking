package com.antonbanking.hibernate;

import java.util.Set;

import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;

import com.antonbanking.business.Account;
import com.antonbanking.business.MyTransaction;

public class AccountDB
{

    private SessionFactory sessionFactory;

    public AccountDB()
    {
        this.sessionFactory = HibernateUtil.getSessionFactory();
    }

    private Session currentSession()
    {
        return sessionFactory.openSession();
    }

    public void insert(Account account)
    {
        currentSession().save(account);
    }

    public void update(Account account)
    {
        currentSession().update(account);
    }

    public Account find(int account_id)
    {
        return (Account) currentSession().createQuery("from accounts").list();
    }

    public Set<MyTransaction> getAllMyTransactionsByID(int account_id)
    {
        Account account = find(account_id);
        return account.getTransactions();
    }

    public String getAccountCurrencyName(int accountId)
    {
        Account account = find(accountId);
        return account.getTypstr();
    }

}
