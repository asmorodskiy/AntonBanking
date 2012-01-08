package com.antonbanking.dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import com.antonbanking.business.MyTransaction;

public class MyTransactionDAO extends MySQLDAO{
	
	public final static String getMaxID="select max(id) from mytransactions;";
	
	public final static String insertTransaction="insert into mytransactions ( id , value , date ) values ( ?,?,?);";
	
	public final static String insertTransactionDic="insert into mytransactionsDic (trans_id , acc_id) values (?,?);";
	
	public final static String delTransaction="delete from mytransactions where id=?;";
	
	public final static String delTransDic="delete from mytransactionsDic where trans_id=?;";
	
	public final static String findTransaction="select value,date from mytransactions where id=?;";
	
	public static final String findAccountTransactions="select trans_id from mytransactionsDic where acc_id=?;";
		
	public MyTransactionDAO() throws ClassNotFoundException, SQLException {
		super();
	}
	
	public MyTransaction insert(int account_id,double val) throws SQLException
	{
		ResultSet rez = executeStatement(getMaxID);
		int tr_id=rez.getInt(1)+1;
		MyTransaction to_ret = new MyTransaction(val);
		to_ret.setID(tr_id);
		PreparedStatement statement = getPreparedStatement(insertTransaction);
		statement.setInt(1,to_ret.getID());
		statement.setDouble(2,to_ret.getTrans_value());
		statement.setDate(3,to_ret.getTrans_date());
		statement.executeQuery();
		statement = getPreparedStatement(insertTransactionDic);
		statement.setInt(1,to_ret.getID());
		statement.setInt(2,account_id);
		statement.executeQuery();
		return to_ret;
	}
	
	public void delete(int trans_id) throws SQLException
	{
		ExecutePreparedStatement(delTransaction,String.valueOf(trans_id));
		ExecutePreparedStatement(delTransDic,String.valueOf(trans_id));
	}
	
	public MyTransaction find(int trans_id) throws SQLException
	{
		PreparedStatement statement=getPreparedStatement(findTransaction);
		statement.setInt(1,trans_id);
		ResultSet rez=statement.executeQuery();
		if(rez.next())
		{
			double val = rez.getDouble(1);
			Date date = rez.getDate(2);
			return new MyTransaction(trans_id,val,date);
		}
		else return null;			
	}
	
	public ArrayList<Integer> getMyTransactionIDs(int acc_id) throws SQLException
	{
		return getDicIDs(findAccountTransactions,acc_id);
	}

	public ArrayList<MyTransaction> getAllMyTransactionsByID(int account_id) throws SQLException
	{
		ArrayList<MyTransaction> to_ret = new ArrayList<MyTransaction>();
		for(Integer acc_id:getMyTransactionIDs(account_id))
			 to_ret.add(find(acc_id));
		return to_ret;
	}

}
