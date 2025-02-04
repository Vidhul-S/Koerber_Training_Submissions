package com.bank.bankApp.exceptions;

public class NoSufficientFundException extends RuntimeException{

    public NoSufficientFundException(String message) {
        super(message);
    }
}
