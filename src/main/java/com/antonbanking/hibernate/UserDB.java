package com.antonbanking.hibernate;

import java.util.ArrayList;
import java.util.Set;

import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
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

    @SuppressWarnings("unchecked")
    public ArrayList<User> findAll() {
	return (ArrayList<User>) currentSession().createQuery("from user")
		.list();
    }

    public Set<Account> getAllAccountsByID(int user_id) {
	User user = find(user_id);
	return user.getAllAccounts();
    }

    public ArrayList<Long> getAccountIDs(int user_id) {
	User user = find(user_id);
	Set<Account> accounts = user.getAllAccounts();
	ArrayList<Long> ids = new ArrayList<Long>();
	for (Account acc : accounts)
	    ids.add(acc.getAcc_id());
	return ids;
    }

}
