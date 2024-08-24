package com.jaimelucas.inditex.prices.application.response;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PriceDTO {

    private Long productId;

    private String startDate;

    private String endDate;

    private Long priceList;

    private Long priority;

    private String currency;

    private Double price;

    private Integer brandId;
}
