package com.currencyExchange.currencyExchange.controller;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@FeignClient(name = "currency-exchange")
public class ExchangeController {

    @GetMapping("/USD/to/INR")
    public double getExchangeRate() {
        return 75.0;
    }

    @GetMapping("/INR/to/USD")
    public double getExchangeRate1() {
        return 0.013;
    }

}
