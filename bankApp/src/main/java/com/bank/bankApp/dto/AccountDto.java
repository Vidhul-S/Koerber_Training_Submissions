package com.bank.bankApp.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Range;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountDto {
    private int id;
    @NotNull(message = "name is required")
    @NotEmpty(message = "name is can't be empty")
    private String name;
    @NotNull(message = "balance can't be null")
    @Range(min = 1000,max = 1000000, message = "balance must be between 1000 and 1000000")
    private BigDecimal balance;

    public AccountDto(String name, BigDecimal balance) {
        this.name = name;
        this.balance = balance;
    }
}
