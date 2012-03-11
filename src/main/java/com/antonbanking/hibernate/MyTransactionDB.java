package com.antonbanking.hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.springframework.beans.factory.annotation.Autowired;

import com.antonbanking.business.MyTransaction;

public class MyTransactionDB {

    private SessionFactory sessionFactory;

    @Autowired
    public MyTransactionDB(SessionFactory sessionFactory) {
	this.sessionFactory = sessionFactory;
    }

    private Session currentSession() {
	return sessionFactory.getCurrentSession();
    }

    public void insert(MyTransaction transaction) {
	currentSession().save(transaction);
    }

    public MyTransaction find(int trans_id) {
	return (MyTransaction) currentSession().createQuery(
		"from mytransactions").list();
    }
}
