package com.bank.bankApp.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.aspectj.weaver.ast.Not;
import org.hibernate.validator.constraints.Range;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransferDto {
    @NotNull(message = "Sender's id is required")
    private int fromid;
    @NotNull(message = "Reciver's id is required")
    private int toid;
    @NotNull(message = "amount can't be null")
    private BigDecimal amount;
}
