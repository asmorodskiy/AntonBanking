package com.antonbanking.business;

import java.util.ArrayList;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "accounts")
public class Account {

    @Column(name = "quantity")
    private double quantity;

    public double changeQuantity(double change) {

	transactions.add(new MyTransaction(change));

	return quantity += change;
    }

    public void setQuantity(double quantity) {

	transactions.clear();

	this.quantity = quantity;
    }

    public double getQantity() {
	return quantity;
    }

    public String getQanstr() {
	return String.valueOf(quantity);
    }

    public String getTypstr() {
	return typ.getName();
    }

    public String getIdstr() {
	return String.valueOf(acc_id);
    }

    public CurrencyType getTyp() {
	return typ;
    }

    public void addTransaction(MyTransaction in) {
	transactions.add(in);
    }

    @Id
    @GeneratedValue
    @Column(name = "acc_id")
    private Long acc_id;

    @Column(name = "typ")
    private CurrencyType typ;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "mytransactionsDic", joinColumns = { @JoinColumn(name = "acc_id") }, inverseJoinColumns = { @JoinColumn(name = "trans_id") })
    private ArrayList<MyTransaction> transactions;

    public void setTransactions(double quantity, ArrayList<MyTransaction> tr) {
	this.quantity = quantity;
	transactions = tr;
    }

    public Account() {
	typ = CurrencyType.hrivna;
	quantity = 0;
	transactions = new ArrayList<MyTransaction>();
    }

    public Account(CurrencyType in_typ) {
	quantity = 0;
	typ = in_typ;
	transactions = new ArrayList<MyTransaction>();
    }

    public boolean sameCurrency(CurrencyType in) {
	return typ.equals(in);
    }

    public ArrayList<MyTransaction> getTransactions() {
	return transactions;
    }

    public Long getAcc_id() {
	return acc_id;
    }

    public void setAcc_id(Long acc_id) {
	this.acc_id = acc_id;
    }
}
