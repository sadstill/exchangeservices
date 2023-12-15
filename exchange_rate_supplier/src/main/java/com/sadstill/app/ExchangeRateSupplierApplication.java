package com.sadstill.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ExchangeRateSupplierApplication {
    public static void main(String[] args) {
        SpringApplication.run(ExchangeRateSupplierApplication.class, args);
    }
}
