package com.antonbanking.business;

import java.util.ArrayList;

import com.antonbanking.utils.RandomGen;

public class Account {
	
	private double quantity;
	private int id;
	private CurrencyType typ;
	private ArrayList<MyTransaction> transactions;
	
	public Account(){
		id = RandomGen.GenerateID();
		typ = CurrencyType.hrivna;
		transactions = new ArrayList<MyTransaction>();
	}
	
	public Account(CurrencyType in_typ){
		id = RandomGen.GenerateID();
		typ = in_typ;
		transactions = new ArrayList<MyTransaction>();
	}
	
	public Account(CurrencyType in_typ,ArrayList<MyTransaction> in_arr){
		id = RandomGen.GenerateID();
		typ = in_typ;
		transactions.addAll(in_arr);
	}
}
