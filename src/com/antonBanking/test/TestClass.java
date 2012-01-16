package com.antonBanking.test;

import java.sql.SQLException;
import java.util.ArrayList;

import com.antonbanking.business.User;
import com.antonbanking.dao.UserDAO;

public class TestClass {

	/**
	 * @param args
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		UserDAO db_usr = new UserDAO();
		
		ArrayList<User> usr = db_usr.findAll();
		
		for(User u1 : usr)
		System.out.println(u1.getName());	
		
	}

}
