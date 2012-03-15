package com.antonbanking.hibernate;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class HibernateUtil
{
    private static final SessionFactory sessionFactory;

    private static Logger lg = Logger.getLogger(HibernateUtil.class);

    static
    {
        try
        {
            Configuration conf = new Configuration().configure("hibernate.cfg.xml");
            sessionFactory = conf.buildSessionFactory();
        }
        catch (Throwable ex)
        {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory()
    {
        return sessionFactory;
    }

    public static void Rollback(Transaction tx, String message)
    {
        lg.error(message);
        lg.error("Rolling back transaction");
        tx.rollback();
    }
}
