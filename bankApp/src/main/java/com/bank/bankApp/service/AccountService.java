package com.bank.bankApp.service;

import com.bank.bankApp.dto.AccountDto;
import com.bank.bankApp.dto.DepositDto;
import com.bank.bankApp.dto.TransferDto;
import com.bank.bankApp.dto.WithdrawDto;


import java.util.List;

public interface AccountService {
    public List<AccountDto> getAllAccount();
    public AccountDto getAccount(AccountDto accountDto);
    public String transfer(TransferDto transferDto);
    public String deposit(DepositDto depositDto);
    public String withdraw(WithdrawDto withdrawDto);
}
