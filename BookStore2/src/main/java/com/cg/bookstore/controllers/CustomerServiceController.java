package com.cg.bookstore.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.cg.bookstore.beans.Customer;
import com.cg.bookstore.exceptions.CustomerAlreadyRegisteredException;
import com.cg.bookstore.exceptions.CustomerNotFound;
import com.cg.bookstore.services.CustomerServicesImpl;

@Controller
public class CustomerServiceController {
	@Autowired
	CustomerServicesImpl customerServices;
	
	@RequestMapping(value = {"/test"}, method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_UTF8_VALUE,headers="Accept=appliaction/json")
	public ResponseEntity<String> testCon(){
		return new ResponseEntity<>("done",HttpStatus.OK);
	}
	
	@RequestMapping(value = {"/acceptDetails"}, method=RequestMethod.POST, consumes=MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	public ResponseEntity<String> acceptCustomer(@ModelAttribute Customer customer) throws CustomerAlreadyRegisteredException{
		customer=customerServices.acceptCustomerDetails(customer);
		return new ResponseEntity<>("Registered with "+customer.getEmailId(),HttpStatus.OK);
	}
	
	@RequestMapping(value= {"/editCustomer"},method=RequestMethod.PUT,
			consumes= MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	public ResponseEntity<String> editCustomerDetails(@ModelAttribute Customer customer) throws CustomerNotFound{
		customer=customerServices.editCustomer(customer);
		return new ResponseEntity<>("Customer details updated successfully Customer emailId :-"+customer.getEmailId(),HttpStatus.OK);
	}
	
	@RequestMapping(value= {"/findCustomer"},method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE,headers="Accept=application/json")
	public ResponseEntity<Customer> findProductDetails(@RequestParam String id) throws CustomerNotFound{
		Customer customer=customerServices.findCustomerById(id);
		return new ResponseEntity<Customer>(customer,HttpStatus.OK);
	}
	
	@RequestMapping(value = {"/deleteCustomer"}, method=RequestMethod.DELETE, consumes=MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	public ResponseEntity<String> deleteCustomerDetails(@RequestParam String email) throws CustomerNotFound{
		customerServices.deleteCustomer(email);
		return new ResponseEntity<>("Customer dleted with emailId "+email,HttpStatus.OK);
	}
}
