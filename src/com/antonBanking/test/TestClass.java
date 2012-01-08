package com.antonBanking.test;

import java.sql.SQLException;

import com.antonbanking.business.CurrencyType;
import com.antonbanking.dao.UserDAO;

public class TestClass {

	/**
	 * @param args
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		CurrencyType typ = CurrencyType.hrivna;
		
		System.out.println(typ.getInt());
	}

}
