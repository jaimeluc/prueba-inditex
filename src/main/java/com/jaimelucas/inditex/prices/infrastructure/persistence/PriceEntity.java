package com.jaimelucas.inditex.prices.infrastructure.persistence;


import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "PRICES")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PriceEntity {

    @EmbeddedId
    private PriceId id;

    @Column(name = "END_DATE")
    private LocalDateTime endDate;

    @Column(name = "PRICE_LIST")
    private Long priceList;

    @Column(name = "CURR")
    private String currency;

    @Column(name = "PRICE")
    private Double price;


}