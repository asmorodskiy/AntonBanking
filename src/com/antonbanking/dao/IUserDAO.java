package com.antonbanking.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import com.antonbanking.business.User;

public interface IUserDAO {

	public User insert(String username) throws SQLException;
	
	
	public void delete(int id) throws SQLException, ClassNotFoundException;
		
	
	public User find(int id) throws SQLException, ClassNotFoundException;
	
	
	public ArrayList<User> findAll() throws SQLException, ClassNotFoundException;	
	
}
