package com.antonbanking.test;

import java.sql.SQLException;

import com.antonbanking.business.User;
import com.antonbanking.service.MainService;

public class TestHibernate {
    public static void main(String[] args) throws ClassNotFoundException,
	    SQLException {
	User user = MainService.testUserReturning(1);
	System.out.println(user.getAllAccounts().isEmpty());
    }
}
