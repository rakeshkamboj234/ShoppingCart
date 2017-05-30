package com.cart.dao;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.cart.entity.Account;

 public interface AccountDAO{
	public Account findAccount(String userName);

	public Account loginUser(String userName, String userPassword);
}