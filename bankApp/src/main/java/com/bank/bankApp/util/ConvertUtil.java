package com.bank.bankApp.util;

import com.bank.bankApp.dto.AccountDto;
import com.bank.bankApp.dto.DepositDto;
import com.bank.bankApp.entities.Account;

public class ConvertUtil {
    public static Account convertToAccount(AccountDto accountDto) {
        return new Account(accountDto.getId(),accountDto.getName(), accountDto.getBalance());
    }
    public static AccountDto convertToAccountDto(Account account) {
        return new AccountDto(account.getId(),account.getName(), account.getBalance());
    }
}
