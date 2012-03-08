package com.antonbanking.hibernate;

import java.util.ArrayList;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.antonbanking.business.Account;
import com.antonbanking.business.MyTransaction;

public class AccountDB {

    private HibernateTemplate hibernateTemplate;

    public void setSessionFactory(SessionFactory sessionFactory) {
	this.hibernateTemplate = new HibernateTemplate(sessionFactory);
    }

    public void insert(Account account) {
	hibernateTemplate.save(account);
    }

    public void update(Account account) {
	hibernateTemplate.update(account);
    }

    public Account find(int account_id) {
	return hibernateTemplate.load(Account.class, new Long(account_id));
    }

    public ArrayList<MyTransaction> getAllMyTransactionsByID(int account_id) {
	Account account = find(account_id);
	return account.getTransactions();
    }

    public String getAccountCurrencyName(int accountId) {
	Account account = find(accountId);
	return account.getTypstr();
    }

}
