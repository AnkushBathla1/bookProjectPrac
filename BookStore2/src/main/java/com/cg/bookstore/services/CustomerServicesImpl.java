package com.cg.bookstore.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cg.bookstore.beans.Customer;
import com.cg.bookstore.daoservices.CustomerDAOServices;
import com.cg.bookstore.exceptions.CustomerNotFound;
@Component("customerServices")
public class CustomerServicesImpl implements ICustomerServices{

	@Autowired
	private CustomerDAOServices customerDAOServices;
	@Override
	public Customer acceptCustomerDetails(Customer customer) {
		return customerDAOServices.save(customer);
	}

	@Override
	public Customer editCustomer(Customer customer) throws CustomerNotFound {
		customer = findCustomerById(customer.getEmailId());
		if(customer!=null)
		customerDAOServices.save(customer);
		return customer;
	}

	@Override
	public Customer findCustomerById(String email) throws CustomerNotFound {
		return customerDAOServices.findById(email).orElseThrow(()->new CustomerNotFound("Sorry this email is not registered"));
	}

	@Override
	public void deleteCustomer(String email) throws CustomerNotFound {
		Customer customer=findCustomerById(email);
		if(customer!=null)
		customerDAOServices.delete(customer);
		else throw new CustomerNotFound();
	}

}
