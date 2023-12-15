package com.sadstill.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class CurrencyRateDto {
    private String sourceCurrency;
    private String targetCurrency;
    private BigDecimal rate;
}
