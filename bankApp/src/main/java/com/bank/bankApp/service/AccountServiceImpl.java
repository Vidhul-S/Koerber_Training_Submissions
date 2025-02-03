package com.bank.bankApp.service;

import com.bank.bankApp.dto.AccountDto;
import com.bank.bankApp.dto.DepositDto;
import com.bank.bankApp.dto.TransferDto;
import com.bank.bankApp.dto.WithdrawDto;
import com.bank.bankApp.entities.Account;
import com.bank.bankApp.util.ConvertUtil;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class AccountServiceImpl implements AccountService {

    @Autowired
    private Account account;

    @Override
    public List<AccountDto> getAllAccount() {
        return List.of();
    }

    @Override
    public AccountDto getAccount(AccountDto accountDto) {
        return null;
    }

    @Override
    public String transfer(TransferDto transferDto) {
        return "";
    }

    @Override
    public String deposit(DepositDto depositDto) {
        Account acc = ConvertUtil.convertToAccount(account.getById(depositDto.getAccountid()));
        return "";
    }

    @Override
    public String withdraw(WithdrawDto withdrawDto) {
        return "";
    }
}
