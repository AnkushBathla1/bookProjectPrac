package com.cg.bookstore.services;

import com.cg.bookstore.beans.Category;
import com.cg.bookstore.exceptions.CategoryNotFoundException;

public interface ICategoryServices {
public Category createCategory(Category category);
public void deleteCatgory(String categoryName) throws CategoryNotFoundException;
public Category editCategory(Category category) throws CategoryNotFoundException;
public Category getCategoryDetails(String categoryName) throws CategoryNotFoundException;
}
