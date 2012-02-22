package com.antonbanking.hibernate;

import java.sql.SQLException;
import java.util.ArrayList;

import com.antonbanking.business.User;
import com.antonbanking.dao.IUserDAO;


//@Entity
public class UserDB implements IUserDAO {

	@Override
	public User insert(String username) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(int id) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub

	}

	@Override
	public User find(int id) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<User> findAll() throws SQLException,
			ClassNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

}
