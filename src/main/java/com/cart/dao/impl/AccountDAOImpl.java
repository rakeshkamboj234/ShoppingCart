package com.cart.dao.impl;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.cart.dao.AccountDAO;
import com.cart.entity.Account;


@Transactional
public class AccountDAOImpl implements AccountDAO{
	@Autowired
	private SessionFactory sessionFactory;
	
	public Account findAccount(String userName){
		Session session=sessionFactory.getCurrentSession();
		Criteria criteria=session.createCriteria(Account.class);
		criteria.add(Restrictions.eq("userName", userName));
		return (Account)criteria.uniqueResult();	
	}

	public Account loginUser(String userName, String userPassword) {
		Session session=sessionFactory.getCurrentSession();
		Criteria criteria=session.createCriteria(Account.class);
		criteria.add(Restrictions.eq("userName", userName));
		criteria.add(Restrictions.eq("password", userPassword));
		return (Account)criteria.uniqueResult();
	}
}