package com.sadstill.app.controller;


import com.sadstill.app.dto.ConversionDto;
import com.sadstill.app.service.CurrencyConverterService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.math.BigDecimal;

@RestController
@RequiredArgsConstructor
@RequestMapping("/converter")
public class CurrencyConverterController {

    private final CurrencyConverterService currencyConverterService;

    @GetMapping("/currency-converter")
    public BigDecimal convert(@RequestBody ConversionDto conversionDto) {
        return currencyConverterService.getConvertedCurrency(
                conversionDto.getSourceCurrency(),
                conversionDto.getTargetCurrency(),
                conversionDto.getAmount()
        ).block();
    }

}