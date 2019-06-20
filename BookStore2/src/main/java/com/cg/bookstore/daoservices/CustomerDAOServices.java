package com.cg.bookstore.daoservices;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.bookstore.beans.Customer;

public interface CustomerDAOServices extends JpaRepository<Customer, String>{

}
