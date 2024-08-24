package com.jaimelucas.inditex.prices.infrastructure.inputadapter.http;

import com.jaimelucas.inditex.prices.application.response.PriceDTO;
import com.jaimelucas.inditex.prices.infrastructure.inputport.PriceInputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PriceAPI {

    private final PriceInputPort priceInputPort;

    @Autowired
    public PriceAPI(PriceInputPort priceInputPort) {
        this.priceInputPort = priceInputPort;
    }

    @GetMapping("price")
    public ResponseEntity<PriceDTO> getPrice(@RequestParam("applicationDate") String applicationDate,
                                             @RequestParam("productId") Long productId, @RequestParam("brandId") Integer brandId){

        PriceDTO priceDTO = priceInputPort.getByBrandAndProductAndDate(applicationDate, productId, brandId);

        return new ResponseEntity<>(priceDTO, HttpStatus.OK);

    }
}
