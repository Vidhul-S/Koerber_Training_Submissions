package com.bank.bankApp.util;

import com.bank.bankApp.entities.Account;
import com.bank.bankApp.repo.AccountRepo;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
@AllArgsConstructor
public class Initilizer implements CommandLineRunner {
    @Autowired
    private AccountRepo accountRepo;
    @Override
    public void run(String... args) throws Exception {
        accountRepo.save(new Account("John",new BigDecimal("1000")));
        accountRepo.save(new Account("Jane",new BigDecimal("20000")));
        accountRepo.save(new Account("Jack",new BigDecimal("3000")));
        accountRepo.save(new Account("Jill",new BigDecimal("40000")));
    }
}
