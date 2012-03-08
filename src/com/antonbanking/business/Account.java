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

    private double quantity;

    public double changeQuantity(double change) {

	transactions.add(new MyTransaction(change));

	return quantity += change;
    }

    public void setQuantity(double quantity) {

	transactions.clear();

	this.quantity = quantity;
    }

    @Column(name = "quantity")
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

    @Column(name = "typ")
    public CurrencyType getTyp() {
	return typ;
    }

    public void addTransaction(MyTransaction in) {
	transactions.add(in);
    }

    private Long acc_id;

    private CurrencyType typ;

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

    public Account(CurrencyType in_typ, ArrayList<MyTransaction> in_arr) {
	quantity = 0;
	typ = in_typ;
	transactions.addAll(in_arr);
    }

    public boolean sameCurrency(CurrencyType in) {
	return typ.equals(in);
    }

    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "mytransactionsDic", joinColumns = { @JoinColumn(name = "acc_id") }, inverseJoinColumns = { @JoinColumn(name = "trans_id") })
    public ArrayList<MyTransaction> getTransactions() {
	return transactions;
    }

    @Id
    @GeneratedValue
    @Column(name = "acc_id")
    public Long getAcc_id() {
	return acc_id;
    }

    public void setAcc_id(Long acc_id) {
	this.acc_id = acc_id;
    }
}
