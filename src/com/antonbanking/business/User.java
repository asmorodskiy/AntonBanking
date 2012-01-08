package com.antonbanking.business;

import java.util.ArrayList;
import java.util.List;

public class User {
	
	private String name;

	private int id;
	
	private ArrayList<Account> allAccounts;
	
	public User() {		
		
		name = "DefaultUser"+id;
		
		allAccounts = new ArrayList<Account>();
	}
	
	public User(String in_Name) {		
		
		name = in_Name;
		
		allAccounts = new ArrayList<Account>();
	}

	public User(String in_Name,ArrayList<Account> in_array) {		
		
		name = in_Name;
		
		allAccounts.addAll(in_array); 
	}
	
	public int getID() { return id; }
	
	public void setID(int id)
	{
		this.id=id;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public List<Account> getAllAccounts() {
		return allAccounts;
	}

	
	public boolean delAccount(int in_id)
	{
		for(Account ac1: allAccounts)
			if(ac1.getId()==in_id)
			{
				allAccounts.remove(ac1);
				return true;
			}
		return false;
	}
	
	public boolean addAccount(Account in_Account) {		
		
		if(HasThisCurrency(in_Account.getTyp())) return false;
		else 
		{
			allAccounts.add(in_Account);
			return true;
		}
	}
	
	public boolean HasThisCurrency(CurrencyType typ)
	{
		for(Account ac1 : allAccounts)
			if(ac1.sameCurrency(typ)) return true;
		return false;
	}
	
}
