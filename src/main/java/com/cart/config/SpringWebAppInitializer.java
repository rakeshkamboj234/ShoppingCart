package com.cart.config;

import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.DispatcherServlet;

public class SpringWebAppInitializer implements WebApplicationInitializer{

	public void onStartup(ServletContext arg0) throws ServletException {
		AnnotationConfigWebApplicationContext ac=new AnnotationConfigWebApplicationContext();
		ac.register(ApplicationContextConfig.class);
		ServletRegistration.Dynamic sc=arg0.addServlet("SpringDispatcher", new DispatcherServlet(ac));
		sc.setLoadOnStartup(1);
		sc.addMapping("/");		
	}
	
}