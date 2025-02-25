package com.book.bookApp.util;

import com.book.bookApp.repo.BookRepo;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class Initilizer implements CommandLineRunner {
    @Autowired
    private BookRepo bookRepo;
    @Override
    public void run(String... args) throws Exception {
        bookRepo.save(new com.book.bookApp.entities.Book("12345","The Lord of the Rings","J.R.R Tolkien",15.99));
        bookRepo.save(new com.book.bookApp.entities.Book("12346","The Hobbit","J.R.R Tolkien",9.99));
        bookRepo.save(new com.book.bookApp.entities.Book("12347","The Silmarillion","J.R.R Tolkien",12.99));
    }
}
