package com.sadstill.service.repository;

import com.sadstill.service.model.CurrencyRate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface CurrencyRateRepository extends JpaRepository<CurrencyRate, Long> {
    Optional<CurrencyRate> findBySourceCurrencyAndTargetCurrency(String sourceCurrency, String targetCurrency);
}
