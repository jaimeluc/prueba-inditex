package com.jaimelucas.inditex.prices.infrastructure.inputadapter.http;

import com.jaimelucas.inditex.prices.application.response.PriceDTO;
import com.jaimelucas.inditex.prices.infrastructure.inputport.PriceInputPort;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Tag(name = "Price", description = "Price-related operations")
public class PriceAPI {

    private final PriceInputPort priceInputPort;

    @Autowired
    public PriceAPI(PriceInputPort priceInputPort) {
        this.priceInputPort = priceInputPort;
    }

    @Operation(summary = "Retrieves price by application date, product Id and brand Id", description = "Retrieves the highest priority price within the date range")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful operation, price found"),
            @ApiResponse(responseCode = "404", description = "Price not found"),
            @ApiResponse(responseCode = "400", description = "Bad Request - Invalid date format")

    })
    @GetMapping("price")
    public ResponseEntity<PriceDTO> getPrice(
            @Parameter(description = "Application date", example = "2020-06-15 21.00.00", required = true) @RequestParam("applicationDate") String applicationDate,
            @Parameter(description = "Product Id", example = "35455", required = true) @RequestParam("productId") Long productId,
            @Parameter(description = "Brand Id", example = "1", required = true) @RequestParam("brandId") Integer brandId){

        PriceDTO priceDTO = priceInputPort.getByBrandAndProductAndDate(applicationDate, productId, brandId);

        return new ResponseEntity<>(priceDTO, HttpStatus.OK);

    }
}
