package com.bankApplication.bank.repo;

import com.bankApplication.bank.entites.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {
}