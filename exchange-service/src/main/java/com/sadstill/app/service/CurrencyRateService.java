package com.sadstill.app.service;


import com.sadstill.app.model.CurrencyRate;
import com.sadstill.app.repository.CurrencyRateRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CurrencyRateService {

    private final CurrencyRateRepository currencyRateRepository;

    public List<CurrencyRate> getAllCurrencyRates() {
        return currencyRateRepository.findAll();
    }

    public void updateCurrencyRate(String sourceCurrency, String targetCurrency, BigDecimal rate) {
        Optional<CurrencyRate> existingRate = currencyRateRepository
                .findBySourceCurrencyAndTargetCurrency(sourceCurrency, targetCurrency);

        existingRate.ifPresentOrElse(
                existing -> {
                    existing.setRate(rate);
                    existing.setTimestamp(LocalDateTime.now());
                    currencyRateRepository.save(existing);
                },

                () -> {
                    CurrencyRate newRate = CurrencyRate.builder()
                            .sourceCurrency(sourceCurrency)
                            .targetCurrency(targetCurrency)
                            .rate(rate)
                            .timestamp(LocalDateTime.now())
                            .build();

                    currencyRateRepository.save(newRate);
                }
        );
    }

}