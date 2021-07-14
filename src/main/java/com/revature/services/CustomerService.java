package com.revature.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.revature.daos.CustomerDAO;
import com.revature.daos.CustomerDAOImpl;
import com.revature.models.Customer;

public class CustomerService {
	
	private static Logger logger = LoggerFactory.getLogger(CustomerService.class);

	public Customer getCustomerInfo(int num) {
		// TODO Auto-generated method stub
		logger.debug("getting customer data for " + num);
		CustomerDAO customerDAO = new CustomerDAOImpl();
		Customer customer = new Customer();
		customer = customerDAO.getCustomerById(num);
		return customer;
	}

}
