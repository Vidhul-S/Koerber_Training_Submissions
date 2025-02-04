package com.bank.bankApp.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Range;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DepositDto {
    @NotNull(message = "Account id is required")
    private  int accountid;
    @NotNull(message = "amount can't be null")
    @Range(min = 100, message = "can't deposit amount less than 100")
    private BigDecimal amount;
}
