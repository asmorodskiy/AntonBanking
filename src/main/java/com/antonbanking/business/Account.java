package com.antonbanking.business;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity(name = "accounts")
@Table(name = "accounts")
public class Account
{

    @Column(name = "quantity")
    private double quantity;

    @Id
    @GeneratedValue
    @Column(name = "acc_id")
    private Long acc_id;

    @Column(name = "typ")
    private CurrencyType typ;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "mytransactionsDic", joinColumns = { @JoinColumn(name = "acc_id", referencedColumnName = "acc_id") }, inverseJoinColumns = { @JoinColumn(name = "trans_id", referencedColumnName = "trans_id") })
    @LazyCollection(value = LazyCollectionOption.FALSE)
    private Set<MyTransaction> transactions;

    public Account()
    {
        typ = CurrencyType.hrivna;
        quantity = 0;
        transactions = new HashSet<MyTransaction>();
    }

    public Account(CurrencyType in_typ)
    {
        quantity = 0;
        typ = in_typ;
        transactions = new HashSet<MyTransaction>();
    }

    public boolean sameCurrency(CurrencyType in)
    {
        return typ.equals(in);
    }

    public double getQuantity()
    {
        return quantity;
    }

    public Long getAcc_id()
    {
        return acc_id;
    }

    public CurrencyType getTyp()
    {
        return typ;
    }

    public Set<MyTransaction> getTransactions()
    {
        return transactions;
    }

    public void setQuantity(double quantity)
    {
        this.quantity = quantity;
    }

    public void setAcc_id(Long acc_id)
    {
        this.acc_id = acc_id;
    }

    public void setTyp(CurrencyType typ)
    {
        this.typ = typ;
    }

    public void setTransactions(Set<MyTransaction> transactions)
    {
        this.transactions = transactions;
    }

    public String typToString()
    {
        return typ.getName();
    }

    public void addTransaction(MyTransaction transaction)
    {
        this.quantity += transaction.getValue();
        transactions.add(transaction);
    }
}
