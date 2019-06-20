package com.cg.bookstore.daoservices;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.bookstore.beans.Category;

public interface CategoryDAOServices extends JpaRepository<Category,String> {

}
