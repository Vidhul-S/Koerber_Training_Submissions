package com.book;

import com.book.util.BookConfig;
import com.book.model.Book;
import com.book.service.BookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {

//      ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
//      ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        ApplicationContext context = new AnnotationConfigApplicationContext(BookConfig.class);
        BookService bookService = context.getBean(BookService.class);
        System.out.println(bookService.getAllBooks());

        Book newBook = new Book(0, "XYZ456", "Spring in Action", "Craig Walls", 800);
        bookService.addBook(newBook);

        System.out.println("Updated Books List: " + bookService.getAllBooks());

        bookService.deleteBook(1);

        System.out.println("Updated Books List: " + bookService.getAllBooks());

    }
}

