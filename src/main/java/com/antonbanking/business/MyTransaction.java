package com.antonbanking.business;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "mytransactions")
@Table(name = "mytransactions")
public class MyTransaction {

    @Id
    @GeneratedValue
    @Column(name = "trans_id")
    private Long trans_id;

    @Column(name = "date", nullable = false)
    private Date date;

    @Column(name = "value")
    private double value;

    public Date getDate() {
	return date;
    }

    public double getValue() {
	return value;
    }

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

    public Long getTrans_id() {
	return trans_id;
    }

    public void setTrans_id(Long trans_id) {
	this.trans_id = trans_id;
    }

}
