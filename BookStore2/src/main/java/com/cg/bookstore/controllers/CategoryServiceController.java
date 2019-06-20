package com.cg.bookstore.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.cg.bookstore.beans.Category;
import com.cg.bookstore.exceptions.BookDetailsNotFound;
import com.cg.bookstore.exceptions.CategoryNotFoundException;
import com.cg.bookstore.exceptions.CustomerNotFound;
import com.cg.bookstore.services.CategoryServicesImpl;

public class CategoryServiceController {
	@Autowired
	CategoryServicesImpl categoryServices;
	@RequestMapping(value = {"/acceptCategoryDetails"}, method=RequestMethod.POST, consumes=MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	public ResponseEntity<String> acceptCategory(@ModelAttribute Category category){
		category=categoryServices.createCategory(category);
		return new ResponseEntity<>("Category details added successfuly ",HttpStatus.OK);
	}

	@RequestMapping(value= {"/findCategoty"},method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE,headers="Accept=application/json")
	public ResponseEntity<Category> findCategoryDetails(@RequestParam String categoryName) throws BookDetailsNotFound, CategoryNotFoundException {
		Category category=categoryServices.getCategoryDetails(categoryName);
		return new ResponseEntity<Category>(category,HttpStatus.OK);
	}
	
	@RequestMapping(value= {"/editcategory"},method=RequestMethod.PUT,
			consumes= MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	public ResponseEntity<String> editCategoryDetails(@ModelAttribute Category category) throws CustomerNotFound, BookDetailsNotFound, CategoryNotFoundException{
		categoryServices.editCategory(category);
		return new ResponseEntity<>("Category details updated successfully",HttpStatus.OK);
	}
	
	@RequestMapping(value = {"/deleteBook"}, method=RequestMethod.DELETE, consumes=MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	public ResponseEntity<String> deleteBookDetails(@RequestParam String categoryName) throws BookDetailsNotFound, CategoryNotFoundException {
		categoryServices.deleteCatgory(categoryName);
		return new ResponseEntity<>("Category details deleted with Category Name"+categoryName,HttpStatus.OK);
	}
}
