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

import com.cg.bookstore.beans.Book;
import com.cg.bookstore.exceptions.BookDetailsNotFound;
import com.cg.bookstore.exceptions.CustomerAlreadyRegisteredException;
import com.cg.bookstore.exceptions.CustomerNotFound;
import com.cg.bookstore.services.BookServicesImpl;

@Controller
public class BookServiceController {
	@Autowired
	BookServicesImpl bookServices;
	@RequestMapping(value = {"/acceptBookDetails"}, method=RequestMethod.POST, consumes=MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	public ResponseEntity<String> acceptBook(@ModelAttribute Book book) throws CustomerAlreadyRegisteredException{
		book=bookServices.acceptBookDetails(book);
		return new ResponseEntity<>("Book details added successfuly ",HttpStatus.OK);
	}

	@RequestMapping(value= {"/findBook"},method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE,headers="Accept=application/json")
	public ResponseEntity<Book> findBookDetails(@RequestParam int ISBN_Number) throws BookDetailsNotFound {
		Book book=bookServices.getBookDetails(ISBN_Number);
		return new ResponseEntity<Book>(book,HttpStatus.OK);
	}
	
	@RequestMapping(value= {"/editBook"},method=RequestMethod.PUT,
			consumes= MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	public ResponseEntity<String> editBookDetails(@ModelAttribute Book book) throws CustomerNotFound, BookDetailsNotFound{
		bookServices.editBookDetails(book);
		return new ResponseEntity<>("Book details updated successfully",HttpStatus.OK);
	}
	
	@RequestMapping(value = {"/deleteBook"}, method=RequestMethod.DELETE, consumes=MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	public ResponseEntity<String> deleteBookDetails(@RequestParam int ISBN_Number) throws BookDetailsNotFound {
		bookServices.deleteBook(ISBN_Number);
		return new ResponseEntity<>("Book details deleted with ISBN_Number"+ISBN_Number,HttpStatus.OK);
	}
}
