package com.antonbanking.business;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Digits;

@Entity(name = "mytransactions")
@Table(name = "mytransactions")
public class MyTransaction
{

    @Id
    @GeneratedValue
    @Column(name = "trans_id")
    private Long trans_id;

    @Temporal(TemporalType.DATE)
    @Column(name = "date")
    private Date date;

    @Digits(integer = 5, fraction = 2, message = "Value should have no more than 5 and 2 after come")
    @Column(name = "value")
    private double value;

    public void setDate(Date date)
    {
        this.date = date;
    }

    public void setValue(double value)
    {
        this.value = value;
    }

    public Date getDate()
    {
        return date;
    }

    public double getValue()
    {
        return value;
    }

    public MyTransaction()
    {
        date = new Date(System.currentTimeMillis());
    }

    public MyTransaction(double val)
    {

        date = new Date(System.currentTimeMillis());
        value = val;
    }

    public MyTransaction(Long id, double val, Date date)
    {
        this.trans_id = id;
        this.date = date;
        this.value = val;
    }

    @Override
    public String toString()
    {
        return String.format("Transaction ID=%d , Transaction Time=(%s), Value = %f", trans_id, date.toString(), value);
    }

    public Long getTrans_id()
    {
        return trans_id;
    }

    public void setTrans_id(Long trans_id)
    {
        this.trans_id = trans_id;
    }

    public void makeNegative()
    {
        this.value = -this.value;
    }

}
