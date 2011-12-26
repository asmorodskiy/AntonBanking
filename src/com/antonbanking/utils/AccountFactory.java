package com.antonbanking.utils;

import java.util.ArrayList;

import com.antonbanking.business.CurrencyType;
import com.antonbanking.business.MyTransaction;

public class AccountFactory {
	
	private double quantity;

	public void setTyp(CurrencyType typ) {
		this.typ = typ;
	}

	public ArrayList<MyTransaction> getTransactions() {
		return transactions;
	}

	public void setTransactions(ArrayList<MyTransaction> transactions) {
		this.transactions = transactions;
	}

	public int getId() {
		return id;
	}

	private int id;
	private CurrencyType typ;
	private ArrayList<MyTransaction> transactions;
	
	public AccountFactory() {
		quantity=0;
		id = RandomGen.GenerateID();
		typ = CurrencyType.hrivna;
		transactions = new ArrayList<MyTransaction>();
	}

	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}
	
	public CurrencyType getTyp() {
		return typ;
	}
}
