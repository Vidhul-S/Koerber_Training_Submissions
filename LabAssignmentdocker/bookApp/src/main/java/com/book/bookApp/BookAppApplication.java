package com.book.bookApp;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class BookAppApplication extends SpringBootServletInitializer {


    public static void main(String[] args) {

		SpringApplication.run(BookAppApplication.class, args);
	}
}
