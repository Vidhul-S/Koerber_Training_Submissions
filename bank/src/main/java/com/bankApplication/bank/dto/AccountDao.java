package com.bankApplication.bank.dto;

import com.bankApplication.bank.entites.Account;

public interface AccountDao {
    public void update(Account account);
    public Account find(int id);
}
