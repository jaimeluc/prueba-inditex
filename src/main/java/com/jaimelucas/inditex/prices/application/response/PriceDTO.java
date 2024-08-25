package com.jaimelucas.inditex.prices.application.response;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Schema(description = "Model that represents Price")
public class PriceDTO {

    @Schema(description = "Product identifier", example = "1")
    private Long productId;

    @Schema(description = "Date on which the price begins to apply", example = "2020-06-15T16:00:00")
    private String startDate;

    @Schema(description = "Date on which the price ends to apply", example = "2020-07-15T16:00:00")
    private String endDate;

    @Schema(description = "Applicable price rate identifier", example = "1")
    private Long priceList;

    @Schema(description = "Price application disambiguator. If two rates coincide in a date range, the one with the highest priority is applied", example = "1")
    private Long priority;

    @Schema(description = "ISO currency", example = "EUR")
    private String currency;

    @Schema(description = "Final sale price", example = "10.0")
    private Double price;

    @Schema(description = "Group brand identifier", example = "1")
    private Integer brandId;
}
