package com.sadstill.app.service;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.time.Duration;


@Service
@Slf4j
@AllArgsConstructor
public class ShedulingTaskService {

    private final CurrencyRateService currencyRateService;

    private final CurrencyConverterService currencyConverterService;

    @Transactional
    @Scheduled(fixedDelay = 60000)
    public void updateCurrencyRates() {
        Flux<String> currenciesFlux = Flux.just("USD", "EUR", "CNY");

        currenciesFlux
                .delayElements(Duration.ofMillis(1500))
                .flatMap(currency -> {

                    final String currencyFinal = currency;

                    return currencyConverterService.getConvertedCurrency(currencyFinal, "RUB", "1")
                            .doOnError(
                                    throwable -> log.error("Произошла ошибка конвертации валют.")
                            )
                            .doOnNext(
                                    rate -> currencyRateService
                                            .updateCurrencyRate(currencyFinal, "RUB", rate)
                            );
                })
                .subscribe();
    }


}


