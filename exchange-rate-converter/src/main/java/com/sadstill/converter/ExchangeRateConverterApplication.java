package com.sadstill.converter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ExchangeRateConverterApplication {
    public static void main(String[] args) {
        SpringApplication.run(ExchangeRateConverterApplication.class, args);
    }
}
