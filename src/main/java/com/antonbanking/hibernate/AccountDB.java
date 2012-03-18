package com.antonbanking.hibernate;

import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;

import com.antonbanking.business.Account;
import com.antonbanking.business.MyTransaction;

public class AccountDB {

    private SessionFactory sessionFactory;

    private Transaction tx;

    public AccountDB() {
	this.sessionFactory = HibernateUtil.getSessionFactory();
    }

    private Session currentSession() {
	return sessionFactory.getCurrentSession();
    }

    public void insert(Account account) {
	try {
	    tx = currentSession().beginTransaction();
	    currentSession().save(account);
	    tx.commit();
	} catch (HibernateException ex) {
	    HibernateUtil.Rollback(tx, ex.getMessage());
	}

    }

    public void update(Account account) {
	try {
	    tx = currentSession().beginTransaction();
	    currentSession().update(account);
	    tx.commit();
	} catch (HibernateException ex) {
	    HibernateUtil.Rollback(tx, ex.getMessage());
	}
    }

    public Account find(int account_id) {
	try {
	    tx = currentSession().beginTransaction();
	    Account accountToReturn = (Account) currentSession().get(
		    Account.class, new Long(account_id));
	    tx.commit();
	    return accountToReturn;
	} catch (HibernateException ex) {
	    HibernateUtil.Rollback(tx, ex.getMessage());
	    return null;
	}
    }

    public Set<MyTransaction> getAllMyTransactionsByID(int account_id) {
	try {
	    tx = currentSession().beginTransaction();
	    Account account = find(account_id);
	    Set<MyTransaction> setToReturn = account.getTransactions();
	    return setToReturn;
	} catch (HibernateException ex) {
	    HibernateUtil.Rollback(tx, ex.getMessage());
	    return null;
	}
    }

    public String getAccountCurrencyName(int accountId) {
	try {
	    tx = currentSession().beginTransaction();
	    Account account = find(accountId);
	    String strToReturn = account.typToString();
	    tx.commit();
	    return strToReturn;
	} catch (HibernateException ex) {
	    HibernateUtil.Rollback(tx, ex.getMessage());
	    return null;
	}
    }

}
