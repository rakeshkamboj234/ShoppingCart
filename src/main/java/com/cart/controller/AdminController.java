package com.cart.controller;
import java.util.HashMap;
import java.util.Map;

import com.cart.dao.AccountDAO;
import com.cart.dao.CategoryDAO;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.cart.dao.impl.AccountDAOImpl;
import com.cart.entity.Account;
import com.cart.entity.Product;
import com.cart.model.ProductInfo;

@RestController

public class AdminController {
	/*@Autowired
    private AccountDAO accountDAOImpl;*/
	
	@Autowired
     ProductDAO productDAOImpl;
	
	/*@Autowired
     CategoryDAO categoryDAOImpl;*/
	
	/*	@RequestMapping(value = { "/auth" },method=RequestMethod.GET,produces="application/json")
		public Account check(){
			Account account = accountDAOImpl.findAccount("employee1");
			System.out.println("Account= " + account);
			return account;
		}
		@RequestMapping(value = { "/loginUser" },method=RequestMethod.GET,produces="application/json")
		public Account login(@RequestParam(value="userName",defaultValue="") String userName,@RequestParam(value="userPassword",defaultValue="") String userPassword){
			Account account = accountDAOImpl.loginUser(userName,userPassword);
			System.out.println("Account= " + account);
			return account;
		}*/
	    @RequestMapping(value = { "/productList" },method=RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
	    public Map<?, ?> productList(Model model) {	 
	    	Map<?, ?> listItems = productDAOImpl.findProductList();
			return listItems;
	    }	
	  /*  @RequestMapping(value = { "/categoryList" },method=RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
	    public Map<?, ?> catgoryList(Model model) {	 
	    	Map<?, ?> listItems = categoryDAOImpl.findCategoryList();
			return listItems;
	    }*/	
}
