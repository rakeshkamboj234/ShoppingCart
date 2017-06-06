package com.cart.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.cart.entity.Category;
import com.cart.model.CategoryInfo;
import com.cart.dao.CategoryDAO;
import com.cart.dao.ProductDAO;

@Transactional
public class CategoryDAOImpl implements CategoryDAO {
	@Autowired
	private SessionFactory sessionFactory;
	HashMap<String,List<CategoryInfo>> items=new HashMap<String,List<CategoryInfo>>();
	
	public Map findCategoryList() {
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria=session.createCriteria(Category.class);
		List<CategoryInfo> listItem = (List<CategoryInfo>)criteria.list();
		items.put("listCategory",listItem);
		return items;
	}

}
