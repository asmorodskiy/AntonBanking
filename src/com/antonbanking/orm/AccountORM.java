package com.antonbanking.orm;

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
@Table(name = "accounts")
public class AccountORM {

	private Long acc_id;

	private Double quantity;

	private Integer typ;

	private Set<MyTransactionsORM> accountTransactions = new HashSet<MyTransactionsORM>(
			0);

	public AccountORM() {

	}

	@Column(name = "quantity")
	public Double getQuantity() {
		return quantity;
	}

	@Column(name = "typ")
	public Integer getTyp() {
		return typ;
	}

	public void setQuantity(Double quantity) {
		this.quantity = quantity;
	}

	public void setTyp(Integer typ) {
		this.typ = typ;
	}

	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "mytransactionsDic", joinColumns = { @JoinColumn(name = "acc_id") }, inverseJoinColumns = { @JoinColumn(name = "trans_id") })
	public Set<MyTransactionsORM> getAccountTransactions() {
		return accountTransactions;
	}

	public void setAccountTransactions(
			Set<MyTransactionsORM> accountTransactions) {
		this.accountTransactions = accountTransactions;
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
