package com.cart.config;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import javax.naming.NamingException;
import javax.naming.Reference;
import javax.sql.DataSource;
import javax.xml.ws.BindingType;

import org.hibernate.Cache;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionBuilder;
import org.hibernate.SessionFactory;
import org.hibernate.StatelessSession;
import org.hibernate.StatelessSessionBuilder;
import org.hibernate.TypeHelper;
import org.hibernate.boot.spi.SessionFactoryOptions;
import org.hibernate.engine.spi.FilterDefinition;
import org.hibernate.metadata.ClassMetadata;
import org.hibernate.metadata.CollectionMetadata;
import org.hibernate.stat.Statistics;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.cart.dao.impl.AccountDAOImpl;
import com.cart.dao.impl.CategoryDAOImpl;
import com.cart.dao.impl.ProductDAOImpl;
import com.cart.dao.*;
@Configuration

@EnableTransactionManagement
@ComponentScan("com.cart.*")
@PropertySource("classpath:ds-hibernate-config.properties")
public class ApplicationContextConfig {
		@Autowired
		private Environment env;
		
		@Bean(name="viewResolver")
		public InternalResourceViewResolver getViewResolver(){
			InternalResourceViewResolver ir=new InternalResourceViewResolver();
			ir.setPrefix("resources/index");
			ir.setPrefix(".jsp");
			return ir;
		}
		
	    @Bean(name="dataSource")
		public DataSource getDataSource(){
			DriverManagerDataSource dm=new DriverManagerDataSource();
			dm.setDriverClassName(env.getProperty("ds.database-driver"));
			dm.setUrl(env.getProperty("ds.url"));
			dm.setUsername(env.getProperty("ds.username"));
			dm.setPassword(env.getProperty("ds.password"));
			return dm;
		}
	    
	    private Properties hibernateProperties() {
	        Properties properties = new Properties();
	        properties.put("hibernate.dialect", env.getProperty("hibernate.dialect"));
	        properties.put("hibernate.show_sql", env.getProperty("hibernate.show_sql"));
	        return properties;        
	    }
	    
	    @Bean(name="sessionFactory")
	    public SessionFactory getSessionFactory(DataSource datasource) throws IOException{
	    	LocalSessionFactoryBean factoryBean = new LocalSessionFactoryBean();
	    	factoryBean.setPackagesToScan("com.cart.entity");
	    	factoryBean.setDataSource(datasource);
	    	factoryBean.setHibernateProperties(hibernateProperties());
	    	factoryBean.afterPropertiesSet();
	    	
	    	SessionFactory sessionFactory = factoryBean.getObject();
	    	
	    	return sessionFactory;
	    }
	   /* @Autowired(required=true)
	    @Bean(name="accountDAOImpl")
	    public AccountDAO getAccountDAO(){
	    	return new AccountDAOImpl();
	    }*/
	    
	    @Autowired(required=true)
	    @Bean(name="producttDAOImpl")
	    public ProductDAO getProductDAO(){
	    	return new ProductDAOImpl();
	    }
	   /* @Autowired(required=true)
	    @Bean(name="categoryDAOImpl")
	    public CategoryDAO getCategoryDAO(){
	    	return new CategoryDAOImpl();
	    }*/
	    @Autowired
	    @Bean(name = "transactionManager")
	    public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) {
	        HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);
	        return transactionManager;
	    }
		
}
