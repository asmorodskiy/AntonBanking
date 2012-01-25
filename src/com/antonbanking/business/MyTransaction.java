package com.antonbanking.business;

import java.sql.Date;

public class MyTransaction {	
	
	private int id;
	
	public int getID() {
		return id;
	}
	
	public void setID(int id) { this.id=id;}

	public Date getDate() {
		return date;
	}
	
	public String getDatestr()
	{
		return date.toString();
	}

	public double getValue() {
		return value;
	}
	
	public String getValuestr() {
		return String.valueOf(value);
	}

	private Date date;
	
	private double value;	
	
	public MyTransaction(double val) {
		
		date = new Date(System.currentTimeMillis());		
		value=val;
	}
	
	public MyTransaction(int id,double val,Date date)
	{
		this.id=id;
		this.date=date;
		this.value=val;
	}
	
	@Override
	public String toString()
	{		 
		return String.format("Transaction ID=%d , Transaction Time=(%s), Value = %f",id,date.toString(),value);
	}

}
