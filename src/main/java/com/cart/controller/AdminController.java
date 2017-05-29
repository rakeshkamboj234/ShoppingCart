package com.cart.controller;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import antlr.collections.List;

import com.cart.dao.AccountDAO;
import com.cart.dao.ProductDAO;
import com.cart.dao.impl.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.cart.dao.impl.AccountDAOImpl;
import com.cart.entity.Account;
import com.cart.entity.Product;
import com.cart.model.ProductInfo;

@RestController

public class AdminController {
	@Autowired
    private AccountDAO accountDAOImpl;
	
	@Autowired
    private ProductDAO productDAOImpl;
	
		@RequestMapping(value = { "/auth" },method=RequestMethod.GET,produces="application/json")
		public Account check(){
			Account account = accountDAOImpl.findAccount("employee1");
			System.out.println("Account= " + account);
			return account;
		}
	   	
	    @RequestMapping(value = { "/productList" },method=RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
	    public Map productList(Model model) {	 
	    	Map listItems = productDAOImpl.findProductList();
	    	/*ProductInfo product = new ProductInfo();
	    	product.setCode("123");
	    	product.setName("Rakesh");*/
			
			return listItems;
	    }	
		
}
