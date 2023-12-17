package com.sadstill.storage.service.kafka;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sadstill.dto.CurrencyRateDto;
import com.sadstill.storage.service.CurrencyRateService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@AllArgsConstructor
public class CurrencyRateConsumer {

    CurrencyRateService currencyRateService;

    @KafkaListener(topics = "CurrencyRates", groupId = "cr1")
    public void listenCurrencyRates(String currencyRateJson) {
        log.info("Kafka consumer received the message.");

        Optional<List<CurrencyRateDto>> currencyRateDtoList = Optional.empty();

        try {
            ObjectMapper objectMapper = new ObjectMapper();

            currencyRateDtoList = Optional.ofNullable(
                    objectMapper.readValue(currencyRateJson, new TypeReference<List<CurrencyRateDto>>() {
                    })
            );

        } catch (JacksonException e) {
            log.error("Error with parsing json into List of CurrencyRateDto, " + e);
        }

        currencyRateDtoList.ifPresent(list ->
                list.forEach(cr ->
                        currencyRateService.updateCurrencyRate(
                                cr.getSourceCurrency(),
                                cr.getTargetCurrency(),
                                cr.getRate()
                        )
                )
        );

    }
}