package com.bank.bankApp.controller;

import com.bank.bankApp.dto.AccountDto;
import com.bank.bankApp.dto.DepositDto;
import com.bank.bankApp.dto.TransferDto;
import com.bank.bankApp.dto.WithdrawDto;
import com.bank.bankApp.exceptions.AccountNotFoundException;
import com.bank.bankApp.exceptions.NoSufficientFundException;
import com.bank.bankApp.service.AccountServiceImpl;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/bankapp")
public class AccountCrudController {
    @Autowired
    private AccountServiceImpl accountServiceImpl;

    //get all account
    @GetMapping("/accounts")
    public ResponseEntity<List<AccountDto>> getAllAccount(){
        return ResponseEntity.ok(accountServiceImpl.getAllAccount());
    }

    //get account by id
    @GetMapping("/account/{id}")
    public ResponseEntity<AccountDto> getAccountById(@Valid @PathVariable int id){
        try {
            AccountDto account = accountServiceImpl.getAccountById(id);
            return ResponseEntity.ok(account);
        } catch (AccountNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    //transfer
    @PostMapping("/transfer")
    public ResponseEntity<String> transfer(@Valid @RequestBody TransferDto transferDto){
        try {
            String result = accountServiceImpl.transfer(transferDto);
            return ResponseEntity.ok(result);
        } catch (NoSufficientFundException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred during transfer.");
        }
    }

    //deposit
    @PutMapping("/deposit")
    public ResponseEntity<String> deposit(@Valid @RequestBody DepositDto depositDto){
        return ResponseEntity.ok(accountServiceImpl.deposit(depositDto));
    }

    //withdraw
    @PutMapping("/withdraw")
    public ResponseEntity<String> withdraw(@Valid @RequestBody WithdrawDto withdrawDto){
        try {
            String result = accountServiceImpl.withdraw(withdrawDto);
            return ResponseEntity.ok(result);
        } catch (NoSufficientFundException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Withdrawal failed.");
        }
    }
}
