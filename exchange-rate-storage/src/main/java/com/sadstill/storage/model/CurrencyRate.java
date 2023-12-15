package com.sadstill.storage.model;

import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "currency_rate")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CurrencyRate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "source_currency")
    private String sourceCurrency;

    @Column(name = "target_currency")
    private String targetCurrency;

    @Column(name = "rate", precision = 10, scale = 5)
    private BigDecimal rate;

    @Column(name = "timestamp")
    private LocalDateTime timestamp;

    @Override
    public String toString() {
        return "CurrencyRate{" +
                "id=" + id +
                ", sourceCurrency='" + sourceCurrency + '\'' +
                ", targetCurrency='" + targetCurrency + '\'' +
                ", rate=" + rate +
                ", timestamp=" + timestamp +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CurrencyRate that = (CurrencyRate) o;
        return Objects.equals(id, that.id) && Objects.equals(sourceCurrency, that.sourceCurrency) && Objects.equals(targetCurrency, that.targetCurrency) && Objects.equals(rate, that.rate) && Objects.equals(timestamp, that.timestamp);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, sourceCurrency, targetCurrency, rate, timestamp);
    }
}