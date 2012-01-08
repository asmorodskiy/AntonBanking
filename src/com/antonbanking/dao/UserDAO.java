package com.antonbanking.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.antonbanking.business.User;

public class UserDAO extends MySQLDAO{
	
	public static final String addUserSQL="INSERT into user (name) values (?);";
	
	public static final String getMaxID="select max(id) from user;";
	
	public static final String deleteUser="delete from user where id=?;";	
	
	public static final String findUser="select name from user where id=?";
	
		
	public UserDAO() throws ClassNotFoundException, SQLException {
		super();
	}

	public User insert() throws SQLException
	{		
		User to_add = new User();		
		
		ResultSet resultSet = executeStatement(getMaxID);		
		
		to_add.setID(resultSet.getInt(1)+1);
		
		ExecutePreparedStatement(addUserSQL,to_add.getName());		
		 
		return to_add;
	}
	
	public void delete(int id) throws SQLException, ClassNotFoundException
	{		
		AccountDAO acc = new AccountDAO();		
		for(Integer acc_id:acc.getAccountIDs(id))
			acc.delete(acc_id);
		ExecutePreparedStatement(deleteUser,String.valueOf(id));		
	}	
	
	public User find(int id) throws SQLException, ClassNotFoundException
	{		
		String name= (String)getOneValue(findUser,String.valueOf(id));
		
		AccountDAO acc = new AccountDAO();
		
		return new User(name,acc.getAllAccountsByID(id));
	}

}
