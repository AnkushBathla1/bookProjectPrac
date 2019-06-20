package com.cg.bookstore.services;


import com.cg.bookstore.beans.Customer;
import com.cg.bookstore.exceptions.CustomerAlreadyRegisteredException;
import com.cg.bookstore.exceptions.CustomerNotFound;


public interface ICustomerServices {
	public Customer acceptCustomerDetails(Customer customer) throws CustomerAlreadyRegisteredException;
	public Customer editCustomer(Customer customer)throws CustomerNotFound;
	public Customer findCustomerById(String email)throws CustomerNotFound;
	void deleteCustomer(String email) throws CustomerNotFound;
}
