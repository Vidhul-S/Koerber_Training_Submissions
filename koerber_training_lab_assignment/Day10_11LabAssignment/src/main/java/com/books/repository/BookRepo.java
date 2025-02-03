package com.books.repository;

import com.books.exceptions.DaoException;

import java.util.List;

public interface BookRepo {
    public List<Book> getAllBooks() throws DaoException;

    public Book addBook(Book book) throws DaoException;

    public boolean deleteBook(int id) throws DaoException;

    public boolean updateBook(int id, Book book) throws DaoException;

    public Book getBookById(int id) throws DaoException;
}
