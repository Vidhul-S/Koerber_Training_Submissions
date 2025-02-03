package com.bankApplication.bank.service;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.After;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    @Before("execution(* com.example.bankapp.service.AccountService.*(..))")
    public void logBefore() {
        System.out.println("Executing business method...");
    }

    @After("execution(* com.example.bankapp.service.AccountService.*(..))")
    public void logAfter() {
        System.out.println("Business method executed.");
    }
}
