package com.antonbanking.hibernate;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.antonbanking.business.MyTransaction;

public class MyTransactionDB {

    private HibernateTemplate hibernateTemplate;

    public void setSessionFactory(SessionFactory sessionFactory) {
	this.hibernateTemplate = new HibernateTemplate(sessionFactory);
    }

    public void insert(MyTransaction transaction) {
	hibernateTemplate.save(transaction);
    }

    public MyTransaction find(int trans_id) {
	return hibernateTemplate.load(MyTransaction.class, new Long(trans_id));
    }
}
