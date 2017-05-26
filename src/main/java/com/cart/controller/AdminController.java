package com.cart.controller;
import com.cart.dao.AccountDAO;
import com.cart.dao.impl.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.cart.dao.impl.AccountDAOImpl;
import com.cart.entity.Account;

@Controller

public class AdminController {
	@Autowired
    private AccountDAO accountDAOImpl;
	
		@RequestMapping("/auth")
		public String check(){
			Account account = accountDAOImpl.findAccount("employee1");
			System.out.println("Account= " + account);
			return "Shopping";
		}
}
