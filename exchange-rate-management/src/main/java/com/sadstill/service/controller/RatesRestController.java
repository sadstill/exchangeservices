package com.sadstill.service.controller;

import com.sadstill.service.model.CurrencyRate;
import com.sadstill.service.service.CurrencyRateService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/currencies")
@AllArgsConstructor
public class RatesRestController {

    CurrencyRateService currencyRateService;

    @GetMapping("/rates")
    public List<CurrencyRate> getAllRates() {
        return currencyRateService.getAllCurrencyRates();
    }
}
