package com.cg.bookstore.daoservices;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.bookstore.beans.Review;

public interface ReviewDAOServices extends JpaRepository<Review,Integer> {

}
