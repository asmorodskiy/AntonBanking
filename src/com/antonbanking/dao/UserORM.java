package com.antonbanking.dao;

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

@Entity
@Table(name = "user")
public class UserORM {

	private Long user_id;

	private String name;

	private Set<AccountORM> userAccounts = new HashSet<AccountORM>(0);

	@Id
	@GeneratedValue
	@Column(name = "user_id")
	public Long getUser_id() {
		return user_id;
	}

	@Column(name = "name")
	public String getName() {
		return name;
	}

	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}

	public void setName(String name) {
		this.name = name;
	}

	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "userDic", joinColumns = { @JoinColumn(name = "user_id") }, inverseJoinColumns = { @JoinColumn(name = "acc_id") })
	public Set<AccountORM> getUserAccounts() {
		return userAccounts;
	}

	public void setUserAccounts(Set<AccountORM> userAccounts) {
		this.userAccounts = userAccounts;
	}

}
