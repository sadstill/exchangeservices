package com.sadstill.app.controller;


import com.sadstill.app.model.CurrencyRate;
import com.sadstill.app.service.CurrencyRateService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/rate-info")
public class CurrencyRateController {

    private final CurrencyRateService currencyRateService;

    @GetMapping
    @RequestMapping("/currency-rates")
    public List<CurrencyRate> getCurrencyRates() {
        return currencyRateService.getAllCurrencyRates();
    }

}
