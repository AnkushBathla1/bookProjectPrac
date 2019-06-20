package com.cg.bookstore.services;

import com.cg.bookstore.beans.Book;
import com.cg.bookstore.exceptions.BookDetailsNotFound;

public interface IBookServices {
Book acceptBookDetails(Book book);
Book editBookDetails(Book book) throws BookDetailsNotFound;
void deleteBook(int ISBN_Number) throws BookDetailsNotFound;
Book getBookDetails(int ISBN_Number) throws BookDetailsNotFound;

}
