package com.books.services;

import com.books.exceptions.DaoException;
import com.books.repository.Book;

import java.util.List;

public interface BookServices {
    public List<Book> getAllBooks() throws DaoException;

    public Book addBook(Book book) throws DaoException;

    public boolean deleteBook(int id) throws DaoException;

    public boolean updateBook(int id, Book book) throws DaoException;

    public Book getBookById(int id) throws DaoException;

}
