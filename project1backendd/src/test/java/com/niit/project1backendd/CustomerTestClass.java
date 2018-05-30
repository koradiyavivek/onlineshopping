package com.niit.project1backendd;


import org.junit.BeforeClass;


import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.dao.CustomerDaoImpl;

import com.niit.model.Category;
import com.niit.model.Customer;

import junit.framework.TestCase;

import static org.junit.Assert.*;

import org.junit.Test;

public class CustomerTestClass {
	
	
	static AnnotationConfigApplicationContext annotationConfigApplicationContext;
	static CustomerDaoImpl customerdaoimpl;
	Customer customer;
	Category category;

	
	@BeforeClass
	public static void init()
	{
		annotationConfigApplicationContext = new AnnotationConfigApplicationContext();
		annotationConfigApplicationContext.scan("com");
		annotationConfigApplicationContext.refresh();
		
		customerdaoimpl = (CustomerDaoImpl) annotationConfigApplicationContext.getBean(CustomerDaoImpl.class);
		annotationConfigApplicationContext.close();
	}
	
	
	@Test
public void getAllCustomerTest() {

		
		customerdaoimpl.getAllCustomer();
		
		assert(true);
	}

}
