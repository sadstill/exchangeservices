package com.sadstill.app.controller;

import com.sadstill.app.service.CurrencyConverterService;
import com.sadstill.dto.CurrencyRateDto;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.math.BigDecimal;

@RestController
@AllArgsConstructor
public class CurrencyConverterController {

    private final CurrencyConverterService currencyConverterService;

    @GetMapping("/currency-converter")
    public BigDecimal convert(@RequestBody CurrencyRateDto currencyRateDto) {
        return currencyConverterService.getConvertedCurrency(
                currencyRateDto.getSourceCurrency(),
                currencyRateDto.getTargetCurrency(),
                currencyRateDto.getRate()
        ).block();
    }
}
