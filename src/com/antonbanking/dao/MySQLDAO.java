package com.antonbanking.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;



public class MySQLDAO {

	public static final String DRIVER="com.mysql.jdbc.Driver";
	
	public static final String DBURL="jdbc:mysql://localhost/antonbanking?user=root&password=root";
	 
	private Connection conn; 

	public MySQLDAO()  throws ClassNotFoundException, SQLException  
	{
		  Class.forName(DRIVER);
		  conn=DriverManager.getConnection(DBURL);
	}  
	
	public ResultSet executeStatement(String query) throws SQLException
	{
		Statement statement = conn.createStatement();
		
		ResultSet resultSet = statement.executeQuery(query);
		
		if(resultSet.next()) return resultSet;
		
		else return null;
		
	}
	  	
	public PreparedStatement getPreparedStatement(String query) throws SQLException
	{
		return conn.prepareStatement(query);
	}
	
	public int  ExecutePreparedStatement(String query,String str_param) throws SQLException
	{
		PreparedStatement statement=conn.prepareStatement(query);
		
		statement.setString(1,str_param);		
		
		return statement.executeUpdate();
	}
	
	public Object getOneValue(String query,String str_param) throws SQLException
	{
		PreparedStatement statement=conn.prepareStatement(query);
		
		statement.setString(1,str_param);
		
		ResultSet rez= statement.executeQuery();
		
		if(rez.next()) return rez.getString(1);		
		else return null;	
	}
	
	public ArrayList<Integer> getDicIDs(String query,int id) throws SQLException
	{
		PreparedStatement statement=conn.prepareStatement(query);
		statement.setInt(1,id);
		ResultSet rez=statement.executeQuery();
		ArrayList<Integer> to_ret=new ArrayList<Integer>();
		while(rez.next()) to_ret.add(rez.getInt(1));
		return to_ret;
	}
	
	/*public Integer getOneInteger(String query,String str_param) throws SQLException
	{
		PreparedStatement statement=conn.prepareStatement(query);
		
		statement.setString(1,str_param);
		
		ResultSet rez= statement.executeQuery();
		
		if(rez.next()) return rez.getInt(1);		
		else return null;	
	}*/
}
