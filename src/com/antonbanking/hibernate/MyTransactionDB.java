package com.antonbanking.hibernate;

import java.sql.SQLException;
import java.util.ArrayList;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.antonbanking.business.MyTransaction;

public class MyTransactionDB implements IMyTransactionDAO {

    private HibernateTemplate hibernateTemplate;

    public void setSessionFactory(SessionFactory sessionFactory) {
	this.hibernateTemplate = new HibernateTemplate(sessionFactory);
    }

    @Override
    public MyTransaction insert(int account_id, double val) throws SQLException {
	MyTransaction to_ret = new MyTransaction(val);
	hibernateTemplate.saveOrUpdate(to_ret);
	return to_ret;
    }

    @Override
    public void delete(int trans_id) throws SQLException {
	MyTransaction tr1 = find(trans_id);
	hibernateTemplate.delete(tr1);
    }

    @Override
    public MyTransaction find(int trans_id) throws SQLException {
	return hibernateTemplate.load(MyTransaction.class, new Long(trans_id));
    }

    @Override
    public ArrayList<Integer> getMyTransactionIDs(int acc_id)
	    throws SQLException {
	// TODO Auto-generated method stub
	return null;
    }

}
