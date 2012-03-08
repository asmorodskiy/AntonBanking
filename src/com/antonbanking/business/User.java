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
@Table(name = "user")
public class User {

    private String name;

    private Long userID;

    private ArrayList<Account> allAccounts;

    public User() {

	name = "DefaultUser" + userID;

	allAccounts = new ArrayList<Account>();
    }

    public User(String in_Name) {

	name = in_Name;

	allAccounts = new ArrayList<Account>();
    }

    public User(String in_Name, ArrayList<Account> in_array) {

	name = in_Name;

	allAccounts = new ArrayList<Account>();

	allAccounts.addAll(in_array);
    }

    @Column(name = "name")
    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    public boolean delAccount(int in_id) {
	for (Account ac1 : allAccounts)
	    if (ac1.getAcc_id() == in_id) {
		allAccounts.remove(ac1);
		return true;
	    }
	return false;
    }

    public boolean addAccount(Account in_Account) {

	if (HasThisCurrency(in_Account.getTyp()))
	    return false;
	else {
	    allAccounts.add(in_Account);
	    return true;
	}
    }

    public boolean HasThisCurrency(CurrencyType typ) {
	for (Account ac1 : allAccounts)
	    if (ac1.sameCurrency(typ))
		return true;
	return false;
    }

    @Id
    @GeneratedValue
    @Column(name = "user_id")
    public Long getUserID() {
	return userID;
    }

    public void setUserID(Long userID) {
	this.userID = userID;
    }

    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "userDic", joinColumns = { @JoinColumn(name = "user_id") }, inverseJoinColumns = { @JoinColumn(name = "acc_id") })
    public ArrayList<Account> getAllAccounts() {
	return allAccounts;
    }

    public void setAllAccounts(ArrayList<Account> allAccounts) {
	this.allAccounts = allAccounts;
    }

}
