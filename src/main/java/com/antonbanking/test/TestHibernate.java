package com.antonbanking.test;

import java.sql.SQLException;
import java.util.ArrayList;

import com.antonbanking.business.User;
import com.antonbanking.service.MainService;

public class TestHibernate
{
    public static void main(String[] args) throws ClassNotFoundException, SQLException
    {
        ArrayList<User> userList = MainService.getAllUsers();
        System.out.println(userList.size());
    }
}
