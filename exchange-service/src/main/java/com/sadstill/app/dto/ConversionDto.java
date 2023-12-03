package com.sadstill.app.dto;

import lombok.Data;

@Data
public class ConversionDto {
    private String sourceCurrency;
    private String targetCurrency;
    private String amount;
}
