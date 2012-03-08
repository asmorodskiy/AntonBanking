package com.antonbanking.business;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "mytransactions")
public class MyTransaction {

    private Long trans_id;

    @Column(name = "date", nullable = false)
    public Date getDate() {
	return date;
    }

    public String getDatestr() {
	return date.toString();
    }

    @Column(name = "value")
    public double getValue() {
	return value;
    }

    public String getValuestr() {
	return String.valueOf(value);
    }

    private Date date;

    private double value;

    public MyTransaction() {
    }

    public MyTransaction(double val) {

	date = new Date(System.currentTimeMillis());
	value = val;
    }

    public MyTransaction(Long id, double val, Date date) {
	this.trans_id = id;
	this.date = date;
	this.value = val;
    }

    @Override
    public String toString() {
	return String.format(
		"Transaction ID=%d , Transaction Time=(%s), Value = %f",
		trans_id, date.toString(), value);
    }

    @Id
    @GeneratedValue
    @Column(name = "trans_id")
    public Long getTrans_id() {
	return trans_id;
    }

    public void setTrans_id(Long trans_id) {
	this.trans_id = trans_id;
    }

}
