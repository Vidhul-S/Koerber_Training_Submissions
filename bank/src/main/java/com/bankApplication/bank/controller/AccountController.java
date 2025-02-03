package com.bankApplication.bank.controller;

import com.bankApplication.bank.dto.AccountBean;
import com.bankApplication.bank.entites.Account;
import com.bankApplication.bank.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @PostMapping("/transfer")
    public ResponseEntity<String> transferFunds(@RequestBody AccountBean accountBean) {
        try {
            accountService.transfer(accountBean);
            return ResponseEntity.ok("Transfer successful");
        } catch (Exception e) {
            return ResponseEntity.status(400).body("Transfer failed: " + e.getMessage());
        }
    }

    @GetMapping("/account/{id}")
    public ResponseEntity<Account> getAccount(@PathVariable int id) {
        Account account = accountService.getAccount(id);
        return ResponseEntity.ok(account);
    }
}
