package com.antonbanking.business;

import java.sql.Date;

public class MyTransaction {	
	
	/**
	 * @uml.property  name="id"
	 */
	private int id;
	
	public int getID() {
		return id;
	}
	
	public void setID(int id) { this.id=id;}

	/**
	 * @return
	 * @uml.property  name="date"
	 */
	public Date getDate() {
		return date;
	}
	
	public String getDatestr()
	{
		return date.toString();
	}

	/**
	 * @return
	 * @uml.property  name="value"
	 */
	public double getValue() {
		return value;
	}
	
	public String getValuestr() {
		return String.valueOf(value);
	}

	/**
	 * @uml.property  name="date"
	 */
	private Date date;
	
	/**
	 * @uml.property  name="value"
	 */
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
