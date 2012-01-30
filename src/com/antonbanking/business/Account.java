package com.antonbanking.business;

import java.util.ArrayList;

public class Account {
	
	private double quantity;	
	

	public double changeQuantity(double change) {
		
		transactions.add(new MyTransaction(change));
		
		return quantity+=change;
	}

	public void setQuantity(double quantity) {
		
		transactions.clear();
		
		this.quantity = quantity;
	}
	
	public double getQantity()
	{
		return quantity;
	}
	
	public String getQanstr()
	{
		return String.valueOf(quantity);
	}
	
	public String getTypstr()
	{
		return typ.getName();
	}	

	public int getId() {
		return id;
	}
	
	public String getIdstr() {
		return String.valueOf(id);
	}

	public CurrencyType getTyp() {
		return typ;
	}	
	
	public void addTransaction(MyTransaction in)
	{
		transactions.add(in);		
	}

	private int id;
	private CurrencyType typ;
	private ArrayList<MyTransaction> transactions;
	
	public void setID(int id)
	{
		this.id=id;
	}
	
	public void setTransactions(double quantity,ArrayList<MyTransaction> tr)
	{
		this.quantity=quantity;
		transactions=tr;
	}
	
	public Account(){		
		typ = CurrencyType.hrivna;
		quantity = 0;
		transactions = new ArrayList<MyTransaction>();
	}
	
	public Account(CurrencyType in_typ){
		quantity = 0;
		typ = in_typ;
		transactions = new ArrayList<MyTransaction>();
	}
	
	public Account(CurrencyType in_typ,ArrayList<MyTransaction> in_arr){		
		quantity = 0;
		typ = in_typ;
		transactions.addAll(in_arr);
	}		 

	public boolean sameCurrency(CurrencyType in)
	{
		return typ.equals(in);
	}
}
