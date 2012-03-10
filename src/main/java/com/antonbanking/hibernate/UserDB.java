package com.antonbanking.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.antonbanking.business.Account;
import com.antonbanking.business.User;

@Repository
public class UserDB {

    private SessionFactory sessionFactory;

    @Autowired
    public UserDB(SessionFactory sessionFactory) {
	this.sessionFactory = sessionFactory;
    }

    private Session currentSession() {
	return sessionFactory.getCurrentSession();
    }

    public void insert(User user) {
	currentSession().save(user);
    }

    public void update(User user) {
	currentSession().update(user);
    }

    public User find(int user_id) {
	return (User) currentSession().get(User.class, new Long(user_id));
    }

    public ArrayList<User> findAll() {
	List<User> lst = currentSession().createQuery("from user").list();
	return new ArrayList<User>(lst);
    }

    public ArrayList<Account> getAllAccountsByID(int user_id) {
	User user = find(user_id);
	return user.getAllAccounts();
    }

    public ArrayList<Long> getAccountIDs(int user_id) {
	User user = find(user_id);
	ArrayList<Account> accounts = user.getAllAccounts();
	ArrayList<Long> ids = new ArrayList<Long>();
	for (Account acc : accounts)
	    ids.add(acc.getAcc_id());
	return ids;
    }

}
