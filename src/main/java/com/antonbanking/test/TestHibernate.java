package com.antonbanking.test;

import java.util.ArrayList;

import com.antonbanking.business.User;
import com.antonbanking.hibernate.UserDB;

public class TestHibernate
{
    public static void main(String[] args)
    {
        UserDB userDB = new UserDB();
        ArrayList<User> userList = userDB.findAll();
    }
}
