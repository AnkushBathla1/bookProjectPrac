package com.cg.bookstore.services;

import org.springframework.beans.factory.annotation.Autowired;

import com.cg.bookstore.beans.Category;
import com.cg.bookstore.daoservices.CategoryDAOServices;
import com.cg.bookstore.exceptions.CategoryNotFoundException;

public class CategoryServicesImpl implements ICategoryServices{
    @Autowired
    CategoryDAOServices categoryDaoServices;
	@Override
	public Category createCategory(Category category) {
		categoryDaoServices.save(category);
		return category;
	}

	@Override
	public void deleteCatgory(String categoryName) throws CategoryNotFoundException {
		Category category = getCategoryDetails(categoryName);
		if(category!=null)
		categoryDaoServices.delete(category);
	}

	@Override
	public Category editCategory(Category category) throws CategoryNotFoundException {
		category=getCategoryDetails(category.getCategoryName());
		if(category==null)
		throw new CategoryNotFoundException("sorry category not found");
		else return categoryDaoServices.save(category);
	}

	@Override
	public Category getCategoryDetails(String categoryName) throws CategoryNotFoundException {
		return categoryDaoServices.findById(categoryName).orElseThrow(()-> new CategoryNotFoundException("Sorry no category exist with this id")); 
	}

}
