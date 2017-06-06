package com.cart.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.cart.entity.Account;
import com.cart.entity.Product;
import com.cart.model.ProductInfo;
import com.cart.dao.ProductDAO;

@Transactional
public class ProductDAOImpl implements ProductDAO {
	@Autowired
	SessionFactory sessionFactory;
	HashMap<String,List<ProductInfo>> items=new HashMap<String,List<ProductInfo>>();
	
	public Map findProductList() {
		/*String sql = "select price,name,code from products";*/
		Session session = sessionFactory.getCurrentSession();
		/*Query query = session.createQuery(sql);*/
		Criteria criteria=session.createCriteria(Product.class);
		List<ProductInfo> listItem = (List<ProductInfo>)criteria.list();
		items.put("listItem",listItem);
		return items;
	}
}
