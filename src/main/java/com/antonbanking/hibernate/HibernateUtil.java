package com.antonbanking.hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil
{
    private static final SessionFactory sessionFactory;
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
}
