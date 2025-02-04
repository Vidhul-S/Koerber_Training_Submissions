package com.bank.bankApp;


import com.bank.bankApp.util.Initilizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;
@SpringBootApplication
public class BankAppApplication {

	@Autowired
	private Initilizer initilizer;

    public static void main(String[] args) {

		SpringApplication.run(BankAppApplication.class, args);
	}
}
