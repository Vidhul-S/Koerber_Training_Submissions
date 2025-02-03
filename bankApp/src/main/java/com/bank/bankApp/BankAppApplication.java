package com.bank.bankApp;

import com.bank.bankApp.entities.Account;
import com.bank.bankApp.repo.AccountRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;

@SpringBootApplication
public class BankAppApplication implements CommandLineRunner {

	@Autowired
	private AccountRepo accountRepo;
	public static void main(String[] args) {
		SpringApplication.run(BankAppApplication.class, args);
	}
	@Override
	public void run(String... args) throws Exception {
		 accountRepo.save(new Account("John",new BigDecimal("1000")));
		 accountRepo.save(new Account("Jane",new BigDecimal("20000")));
		 accountRepo.save(new Account("Jack",new BigDecimal("3000")));
		 accountRepo.save(new Account("Jill",new BigDecimal("40000")));
	}
}
