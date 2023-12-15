package com.sadstill.app.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sadstill.app.exception.NotCorrectRequestException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import java.math.BigDecimal;

@Service
@Slf4j
public class CurrencyConverterService {

    @Value("${currencylayer.accessKey}")
    private String accessKey;

    @Value("${currencylayer.baseUrl}")
    private String baseUrl;

    public Mono<BigDecimal> getConvertedCurrency(String from, String to, BigDecimal rate) {
        String apiUrl = String.format("%sconvert?access_key=%s&from=%s&to=%s&amount=%s", baseUrl, accessKey,
                from, to, rate);

        WebClient webClient = WebClient.create();

        return webClient.get()
                .uri(apiUrl)
                .retrieve()
                .bodyToMono(String.class)
                .flatMap(response -> Mono.fromCallable(() -> {
                    ObjectMapper objectMapper = new ObjectMapper();
                    JsonNode rootNode = objectMapper.readTree(response);
                    JsonNode resultNode = rootNode.path("result");
                    return resultNode.decimalValue();
                }))
                .onErrorMap(throwable -> {
                    log.error("Ошибка получения ответа от стороннего API " + throwable);

                    return new NotCorrectRequestException("Invalid request", throwable);
                });
    }

}
