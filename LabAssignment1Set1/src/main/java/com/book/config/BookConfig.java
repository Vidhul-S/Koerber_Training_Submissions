package com.book.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration  // Marks this as a Spring configuration class
@ComponentScan(basePackages = "com.book")  // Enables component scanning
public class BookConfig {

}
