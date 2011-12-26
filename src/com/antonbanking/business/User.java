package com.antonbanking.business;

import java.util.ArrayList;
import java.util.List;

import com.antonbanking.utils.RandomGen;

public class User {
	
	private String Name;

	private int id;
	
	private ArrayList<Account> allAccounts;
	
	public User() {		
		
		id = RandomGen.GenerateID();
		
		Name = "DefaultUser"+id;
		
		allAccounts = new ArrayList<Account>();
	}
	
	public User(String in_Name) {	
		
		id = RandomGen.GenerateID();
		
		Name = in_Name;
		
		allAccounts = new ArrayList<Account>();
	}

	public User(String in_Name,ArrayList<Account> in_array) {		
		
		id = RandomGen.GenerateID();
		
		Name = in_Name;
		
		allAccounts.addAll(in_array); 
	}
	
	public int getID() { return id; }
	
	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}
	
	public List<Account> getAllAccounts() {
		return allAccounts;
	}

	public void addAccount(Account in_Account) {
		allAccounts.add(in_Account);
	}
	
}
