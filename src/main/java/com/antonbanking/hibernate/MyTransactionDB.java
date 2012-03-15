package com.antonbanking.hibernate;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;

import com.antonbanking.business.MyTransaction;

public class MyTransactionDB
{

    private SessionFactory sessionFactory;

    private Transaction tx;

    public MyTransactionDB()
    {
        this.sessionFactory = HibernateUtil.getSessionFactory();
    }

    private Session currentSession()
    {
        return sessionFactory.getCurrentSession();
    }

    public void insert(MyTransaction transaction)
    {
        try
        {
            tx = currentSession().beginTransaction();
            currentSession().save(transaction);
            tx.commit();
        }
        catch (HibernateException ex)
        {
            HibernateUtil.Rollback(tx, ex.getMessage());
        }
    }

    public MyTransaction find(int trans_id)
    {
        try
        {
            tx = currentSession().beginTransaction();
            MyTransaction transactionToReturn = (MyTransaction) currentSession().get(MyTransaction.class, new Long(trans_id));
            tx.commit();
            return transactionToReturn;
        }
        catch (HibernateException ex)
        {
            HibernateUtil.Rollback(tx, ex.getMessage());
            return null;
        }
    }
}
