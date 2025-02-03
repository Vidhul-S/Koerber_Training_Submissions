package com.books.web;

import com.books.repository.Book;
import com.books.services.BookServices;
import com.books.services.BookServicesImp;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("-------------all records---------");
        BookServices bookService = new BookServicesImp();
        List<Book> books = bookService.getAllBooks();
        books.forEach(System.out::println);

        System.out.println("-------------find by id---------");
        Book book = bookService.getBookById(1);

        book.setPrice(2000.00);
        System.out.println("-------------update by id---------");
        bookService.updateBook(1, book);
    }
}
