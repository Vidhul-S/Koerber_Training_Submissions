package com.currencyExchange.currencyConvert.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ConvertController {

    private final RestTemplate restTemplate = new RestTemplate();

    @GetMapping("/USD/to/INR/{quantity}")
    public String convertCurrencyUTI(@PathVariable double quantity) {
        double exchangeRate = restTemplate.getForObject("http://currency-exchange:8000/USD/to/INR", Double.class);
        return "In INR: " + (quantity * exchangeRate);
    }

    @GetMapping("/INR/to/USD/{quantity}")
    public String convertCurrencyITU(@PathVariable double quantity) {
        double exchangeRate = restTemplate.getForObject("http://currency-exchange:8000/INR/to/USD", Double.class);
        return "In USD: " + (quantity * exchangeRate);
    }
}
