package com.antonbanking.hibernate;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.antonbanking.business.Account;
import com.antonbanking.business.User;
import com.antonbanking.orm.AccountORM;
import com.antonbanking.orm.UserORM;

public class UserDB {

    private HibernateTemplate hibernateTemplate;

    public void setSessionFactory(SessionFactory sessionFactory) {
	this.hibernateTemplate = new HibernateTemplate(sessionFactory);
    }

    public void insert(User user) throws SQLException {
	UserORM userORM = new UserORM();
	userORM.setName(user.getName());
	Set<AccountORM> accountsSet =  new HashSet<AccountORM>();
	
	for(Account account: user.getAllAccounts())
	{
	    AccountORM accountORM = new 
	}
	
    }

    public void update(User user) throws SQLException {

    }

    public User find(int user_id) throws SQLException, ClassNotFoundException {
	// TODO Auto-generated method stub
	return null;
    }

    public ArrayList<User> findAll() throws SQLException,
	    ClassNotFoundException {
	// TODO Auto-generated method stub
	return null;
    }

    public ArrayList<Account> getAllAccountsByID(int user_id)
	    throws SQLException, ClassNotFoundException {
	// TODO Auto-generated method stub
	return null;
    }

}
