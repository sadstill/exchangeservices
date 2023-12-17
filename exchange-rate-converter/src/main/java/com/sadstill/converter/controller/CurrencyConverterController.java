package com.sadstill.converter.controller;

import com.sadstill.converter.service.CurrencyConverterService;
import com.sadstill.dto.ConversionDto;
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
    public BigDecimal convert(@RequestBody ConversionDto conversionDto) {
        return currencyConverterService.getConvertedCurrency(
                conversionDto.getSourceCurrency(),
                conversionDto.getTargetCurrency(),
                conversionDto.getSourceValue()
        ).block();
    }

}
