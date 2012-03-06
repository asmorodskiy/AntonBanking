package com.antonbanking.orm;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "mytransactions")
public class MyTransactionsORM {

	private Long trans_id;

	private Double value;

	private Date date;

	public MyTransactionsORM() {
	}

	@Id
	@GeneratedValue
	@Column(name = "trans_id")
	public Long getTrans_id() {
		return trans_id;
	}

	public void setTrans_id(Long id) {
		this.trans_id = id;
	}

	@Column(name = "value")
	public Double getValue() {
		return value;
	}

	public void setValue(Double value) {
		this.value = value;
	}

	@Column(name = "date", nullable = false)
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
}
