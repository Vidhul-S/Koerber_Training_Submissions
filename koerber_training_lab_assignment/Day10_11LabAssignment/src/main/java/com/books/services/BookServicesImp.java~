package com.books.services;

import com.books.exceptions.DaoException;
import com.books.repository.Book;
import com.books.repository.BookRepo;
import com.books.repository.impl.BookRepoJdbcImpl;

import java.util.List;

public class BookServicesImp implements BookServices {

    private BookRepo bookRepo = new BookRepoJdbcImpl();

    @Override
    public List<Book> getAllBooks() throws DaoException {
        return bookRepo.getAllBooks();
    }

    @Override
    public Book addBook(Book book) throws DaoException {
        return bookRepo.addBook(book);
    }

    @Override
    public void deleteBook(int id) throws DaoException {
        bookRepo.deleteBook(id);
    }

    @Override
    public void updateBook(int id, Book book) throws DaoException {
        bookRepo.updateBook(id, book);
    }

    @Override
    public Book getBookById(int id) throws DaoException {
        return bookRepo.getBookById(id);
    }
}
