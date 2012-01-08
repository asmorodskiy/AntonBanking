package com.antonbanking.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.antonbanking.business.Account;
import com.antonbanking.business.CurrencyType;
import com.antonbanking.business.User;

public class AccountDAO extends MySQLDAO{


	public static final String addAccountSQL="insert into accounts (id, quantity , typ ) values(?,?,?);";
	
	public static final String getMaxID="select max(id) from accounts;";
	
	public static final String addToDic="insert into userDic (user_id,account_id) values(?,?);";
	
	public static final String deleteAccount="delete from accounts where id=?;";
	
	public static final String findAccount="select typ,quantity from accounts where id=?";
	
	public static final String findUserAccounts="select account_id from userDic where user_id=?;";
	
	public static final String deleteUserDic="delete from userDic where account_id=?;";
	
	
	public AccountDAO() throws ClassNotFoundException, SQLException {
		super();	
	}
	
	public Account insert(int user_id,double quantity,CurrencyType typ) throws SQLException, ClassNotFoundException
	{
		UserDAO dao_usr = new UserDAO();
		User usr = dao_usr.find(user_id);
		if(usr.HasThisCurrency(typ)) return null;
		else
		{
			ResultSet rez = executeStatement(getMaxID);
			int acc_id=rez.getInt(1)+1;
			Account acc1 = new Account(typ);
			acc1.setQuantity(quantity);
			acc1.setID(acc_id);
			PreparedStatement statement = getPreparedStatement(addAccountSQL);
			statement.setInt(1,acc1.getId());
			statement.setDouble(2,acc1.getQantity());
			statement.setInt(3,typ.getInt());
			statement.executeUpdate();
			statement = getPreparedStatement(addToDic);
			statement.setInt(1,user_id);
			statement.setInt(2,acc_id);
			statement.executeUpdate();
			return acc1;
		}
	}
	
	
	public void delete(int id) throws SQLException {
		ExecutePreparedStatement(deleteAccount,String.valueOf(id));
		ExecutePreparedStatement(deleteUserDic,String.valueOf(id));
	}
	
	public Account find(int id) throws SQLException, ClassNotFoundException 
	{
		PreparedStatement statement=getPreparedStatement(findAccount);
		statement.setInt(1,id);
		ResultSet rez=statement.executeQuery();
		if(rez.next())
		{
			CurrencyType typ = CurrencyType.valueOf(rez.getString(1));
			double quantity = rez.getDouble(2);
			Account to_ret = new Account(typ);
			MyTransactionDAO transDAO = new MyTransactionDAO();
			to_ret.setTransactions(quantity,transDAO.getAllMyTransactionsByID(id));
			to_ret.setID(id);
			return to_ret;
		}
		else return null;
	}
	
	public ArrayList<Integer> getAccountIDs(int user_id) throws SQLException
	{
		return getDicIDs(findUserAccounts,user_id);
	}
	
	public ArrayList<Account> getAllAccountsByID(int user_id) throws SQLException, ClassNotFoundException
	{
		ArrayList<Account> to_ret = new ArrayList<Account>();
		for(Integer acc_id:getAccountIDs(user_id))
			 to_ret.add(find(acc_id));
		return to_ret;
	}

}
