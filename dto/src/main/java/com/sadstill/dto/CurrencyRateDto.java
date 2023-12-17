package com.sadstill.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class CurrencyRateDto {
    private String sourceCurrency;
    private String targetCurrency;
    private BigDecimal rate;

    @JsonCreator
    public CurrencyRateDto(
            @JsonProperty("sourceCurrency") String sourceCurrency,
            @JsonProperty("targetCurrency") String targetCurrency,
            @JsonProperty("rate") BigDecimal rate) {
        this.sourceCurrency = sourceCurrency;
        this.targetCurrency = targetCurrency;
        this.rate = rate;
    }
}
