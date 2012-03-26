package com.antonbanking.hibernate;

import java.util.ArrayList;
import java.util.Set;

import javax.validation.ConstraintViolationException;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;

import com.antonbanking.business.Account;
import com.antonbanking.business.User;

public class UserDB
{

    private SessionFactory sessionFactory;

    private Transaction tx;

    public UserDB()
    {
        this.sessionFactory = HibernateUtil.getSessionFactory();
    }

    private Session currentSession()
    {
        return sessionFactory.getCurrentSession();
    }

    public void insert(User user)
    {
        try
        {
            tx = currentSession().beginTransaction();
            currentSession().save(user);
            tx.commit();
        }
        catch (HibernateException ex)
        {
            HibernateUtil.Rollback(tx, ex.getMessage());
        }
        catch (ConstraintViolationException ex)
        {
            HibernateUtil.Rollback(tx, ex.getMessage());
            throw ex;
        }
    }

    public void update(User user)
    {
        try
        {
            tx = currentSession().beginTransaction();
            currentSession().update(user);
            tx.commit();
        }
        catch (HibernateException ex)
        {
            HibernateUtil.Rollback(tx, ex.getMessage());
        }
    }

    public User find(int user_id)
    {
        try
        {
            tx = currentSession().beginTransaction();
            User userToReturn = (User) currentSession().get(User.class, new Long(user_id));
            tx.commit();
            return userToReturn;
        }
        catch (HibernateException ex)
        {
            HibernateUtil.Rollback(tx, ex.getMessage());
            return null;
        }

    }

    @SuppressWarnings("unchecked")
    public ArrayList<User> findAll()
    {
        try
        {
            tx = currentSession().beginTransaction();
            ArrayList<User> userListToReturn = (ArrayList<User>) currentSession().createQuery("from user").list();
            tx.commit();
            return userListToReturn;
        }
        catch (HibernateException ex)
        {
            HibernateUtil.Rollback(tx, ex.getMessage());
            return null;
        }
    }

    public Set<Account> getAllAccountsByID(int user_id)
    {
        try
        {
            tx = currentSession().beginTransaction();
            User user = (User) currentSession().get(User.class, new Long(user_id));
            Set<Account> setToReturn = user.getAllAccounts();
            tx.commit();
            return setToReturn;
        }
        catch (HibernateException ex)
        {
            HibernateUtil.Rollback(tx, ex.getMessage());
            return null;
        }
    }

    public ArrayList<Long> getAccountIDs(int user_id)
    {
        try
        {
            tx = currentSession().beginTransaction();
            User user = find(user_id);
            Set<Account> accounts = user.getAllAccounts();
            ArrayList<Long> ids = new ArrayList<Long>();
            for (Account acc : accounts)
                ids.add(acc.getAcc_id());
            tx.commit();
            return ids;
        }
        catch (HibernateException ex)
        {
            HibernateUtil.Rollback(tx, ex.getMessage());
            return null;
        }
    }

}
