package com.sadstill.storage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ExchangeRateStorageApplication {
    public static void main(String[] args) {
        SpringApplication.run(ExchangeRateStorageApplication.class, args);
    }
}
