package com.antonbanking.business;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
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

@Entity(name = "user")
@Table(name = "user")
public class User {

    @Column(name = "name")
    private String name;

    @Id
    @GeneratedValue
    @Column(name = "user_id")
    private Long userID;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "userDic", joinColumns = { @JoinColumn(name = "user_id", referencedColumnName = "user_id") }, inverseJoinColumns = { @JoinColumn(name = "acc_id", referencedColumnName = "acc_id") })
    @LazyCollection(value = LazyCollectionOption.FALSE)
    private Set<Account> allAccounts;

    public User() {

	Random rand = new Random(System.currentTimeMillis());

	userID = rand.nextLong() % 9;

	name = "DefaultUser" + userID;

	allAccounts = new HashSet<Account>();
    }

    public User(String in_Name) {

	name = in_Name;

	allAccounts = new HashSet<Account>();
    }

    public User(String in_Name, ArrayList<Account> in_array) {

	name = in_Name;

	allAccounts = new HashSet<Account>();

	allAccounts.addAll(in_array);
    }

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

    public Long getUserID() {
	return userID;
    }

    public void setUserID(Long userID) {
	this.userID = userID;
    }

    public Set<Account> getAllAccounts() {
	return allAccounts;
    }

    public void setAllAccounts(Set<Account> allAccounts) {
	this.allAccounts = allAccounts;
    }

}
