package com.book.bookApp;


import com.book.bookApp.util.Initilizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BookAppApplication {

	@Autowired
	private Initilizer initilizer;

    public static void main(String[] args) {

		SpringApplication.run(BookAppApplication.class, args);
	}
}
