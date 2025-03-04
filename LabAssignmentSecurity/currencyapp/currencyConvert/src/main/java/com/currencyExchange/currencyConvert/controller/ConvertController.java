package com.currencyExchange.currencyConvert.controller;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@FeignClient(name = "currency-convert")
public class ConvertController {

    @GetMapping("/USD/to/INR/{quantity}")
    public String convertCurrencyUTI(@PathVariable double quantity) {
        return "In INR"+Double.toString(quantity * 75);
    }
    @GetMapping("/INR/to/USD/{quantity}")
    public String convertCurrencyITU(@PathVariable double quantity) {
        return "In USD"+Double.toString(quantity / 75);
    }
}
