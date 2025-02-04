package com.bank.bankApp.service;

import com.bank.bankApp.dto.AccountDto;
import com.bank.bankApp.dto.DepositDto;
import com.bank.bankApp.dto.TransferDto;
import com.bank.bankApp.dto.WithdrawDto;
import com.bank.bankApp.entities.Account;
import com.bank.bankApp.exceptions.AccountNotFoundException;
import com.bank.bankApp.repo.AccountRepo;
import com.bank.bankApp.util.ConvertUtil;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
@Transactional
public class AccountServiceImpl implements AccountService {

    private final AccountRepo accountRepo;


    @Override
    public List<AccountDto> getAllAccount() {
        return accountRepo.findAll()
                .stream()
                .map(ConvertUtil::convertToAccountDto)
                .toList();
    }

    @Override
    public AccountDto getAccountById(int id) {;
        return accountRepo.findById(id)
                .map(ConvertUtil::convertToAccountDto)
                .orElseThrow (()->new AccountNotFoundException("Account of id "+id+"not found"));
    }

    @Override
    public String transfer(TransferDto transferDto) {
        Account fromacc = ConvertUtil.convertToAccount(getAccountById(transferDto.getFromid()));
        Account toacc = ConvertUtil.convertToAccount(getAccountById(transferDto.getToid()));
        fromacc.setBalance(fromacc.getBalance().subtract(transferDto.getAmount()));
        toacc.setBalance(toacc.getBalance().add(transferDto.getAmount()));
        accountRepo.save(fromacc);
        accountRepo.save(toacc);
        return "transfer done successfully";
    }

    @Override
    public String deposit(DepositDto depositDto) {
        Account acc = ConvertUtil.convertToAccount(getAccountById(depositDto.getAccountid()));
        acc.setBalance(acc.getBalance().add(depositDto.getAmount()));
        accountRepo.save(acc);
        return "deposit done successfully";
    }

    @Override
    public String withdraw(WithdrawDto withdrawDto) {
        Account acc = ConvertUtil.convertToAccount(getAccountById(withdrawDto.getAccountid()));
        acc.setBalance(acc.getBalance().subtract(withdrawDto.getAmount()));
        accountRepo.save(acc);
        return "withdraw done successfully";
    }
}
