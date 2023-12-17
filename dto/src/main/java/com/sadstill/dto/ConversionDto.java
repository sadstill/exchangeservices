package com.sadstill.dto;

import lombok.Data;

@Data
public class ConversionDto {
    private String sourceCurrency;
    private String targetCurrency;
    private String sourceValue;
}
