package com.antonbanking.business;

import java.sql.Date;

public class MyTransaction {	
	
	private int trans_id;
	
	public int getID() {
		return trans_id;
	}
	
	public void setID(int id) { this.trans_id=id;}

	public Date getTrans_date() {
		return trans_date;
	}

	public double getTrans_value() {
		return trans_value;
	}

	private Date trans_date;
	
	private double trans_value;	
	
	public MyTransaction(double val) {
		
		trans_date = new Date(System.currentTimeMillis());		
		trans_value=val;
	}
	
	public MyTransaction(int id,double val,Date date)
	{
		trans_id=id;
		trans_date=date;
		trans_value=val;
	}
	
	@Override
	public String toString()
	{		 
		return String.format("Transaction ID=%d , Transaction Time=(%s), Value = %f",trans_id,trans_date.toString(),trans_value);
	}

}
