package com.jaimelucas.inditex.prices.infrastructure.outputport;


import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PriceId implements Serializable {

    private static final long serialVersionUID = -4624554460302897655L;

    @Column(name = "PRODUCT_ID")
    private Long productId;

    @Column(name = "START_DATE")
    private LocalDateTime startDate;

    @Column(name = "BRAND_ID")
    private Integer brandId;
}

