package com.cg.bookstore.services;

import org.springframework.beans.factory.annotation.Autowired;

import com.cg.bookstore.beans.Book;
import com.cg.bookstore.daoservices.BookDAOServices;
import com.cg.bookstore.exceptions.BookDetailsNotFound;

public class BookServicesImpl implements IBookServices{
    @Autowired
	BookDAOServices bookDaoServices;
	@Override
	public Book acceptBookDetails(Book book) {
		bookDaoServices.save(book);
		return book;
	}

	@Override
	public Book editBookDetails(Book book) throws BookDetailsNotFound {
		book=getBookDetails(book.getISBN_Number());
		if(book!=null)
		{ bookDaoServices.save(book);
		  return book;
		}
		else throw new BookDetailsNotFound("Sorry Book not found");
		}

	@Override
	public void deleteBook(int ISBN_Number) throws BookDetailsNotFound {
		Book book=getBookDetails(ISBN_Number);
		if(book!=null)
			bookDaoServices.delete(book);
	}

	@Override
	public Book getBookDetails(int ISBN_Number) throws BookDetailsNotFound {
	    Book book= bookDaoServices.findById(ISBN_Number).orElseThrow(()->new BookDetailsNotFound("Sorry book not found")); 
		return book;
	}

}
