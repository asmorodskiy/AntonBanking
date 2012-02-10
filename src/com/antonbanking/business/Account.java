package com.antonbanking.business;

import java.util.ArrayList;

public class Account {
	
	/**
	 * @uml.property  name="quantity"
	 */
	private double quantity;	
	

	public double changeQuantity(double change) {
		
		transactions.add(new MyTransaction(change));
		
		return quantity+=change;
	}

	/**
	 * @param quantity
	 * @uml.property  name="quantity"
	 */
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

	/**
	 * @return
	 * @uml.property  name="id"
	 */
	public int getId() {
		return id;
	}
	
	public String getIdstr() {
		return String.valueOf(id);
	}

	/**
	 * @return
	 * @uml.property  name="typ"
	 */
	public CurrencyType getTyp() {
		return typ;
	}	
	
	public void addTransaction(MyTransaction in)
	{
		transactions.add(in);		
	}

	/**
	 * @uml.property  name="id"
	 */
	private int id;
	/**
	 * @uml.property  name="typ"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private CurrencyType typ;
	/**
	 * @uml.property  name="transactions"
	 * @uml.associationEnd  multiplicity="(0 -1)" elementType="com.antonbanking.business.MyTransaction"
	 */
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
