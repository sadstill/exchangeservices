package com.sadstill.app.service.kafka_producer;

import com.sadstill.app.service.CurrencyConverterService;
import com.sadstill.dto.CurrencyRateDto;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.math.BigDecimal;
import java.time.Duration;
import java.util.List;

@Service
@Slf4j
@AllArgsConstructor
public class CurrencyRateUpdater {

    private final KafkaTemplate<String, List<CurrencyRateDto>> kafkaTemplate;

    private final CurrencyConverterService currencyConverterService;

    @Transactional
    @Scheduled(fixedDelay = 60000)
    public void updateCurrencyRates() {
        Flux<String> currenciesFlux = Flux.just("USD", "EUR", "CNY");

        currenciesFlux
                .delayElements(Duration.ofMillis(1500))
                .flatMap(currency -> {
                    final String currencyFinal = currency;

                    return currencyConverterService.getConvertedCurrency(currencyFinal, "RUB", BigDecimal.valueOf(1))
                            .doOnError(throwable -> log.error("Произошла ошибка конвертации валют."))
                            .map(rate -> new CurrencyRateDto(currencyFinal, "RUB", rate))
                            .onErrorResume(ex -> Mono.empty()); // Пропускаем ошибки, чтобы не прерывать поток
                })
                .collectList()
                .doOnNext(currencyRates -> {
                    kafkaTemplate.send("CurrencyRates", currencyRates);
                })
                .subscribe();
    }

}
