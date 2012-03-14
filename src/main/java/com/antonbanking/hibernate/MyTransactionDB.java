package com.antonbanking.hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;

import com.antonbanking.business.MyTransaction;

public class MyTransactionDB
{

    private SessionFactory sessionFactory;

    public MyTransactionDB()
    {
        this.sessionFactory = HibernateUtil.getSessionFactory();
    }

    private Session currentSession()
    {
        return sessionFactory.openSession();
    }

    public void insert(MyTransaction transaction)
    {
        currentSession().save(transaction);
    }

    public MyTransaction find(int trans_id)
    {
        return (MyTransaction) currentSession().createQuery("from mytransactions").list();
    }
}
