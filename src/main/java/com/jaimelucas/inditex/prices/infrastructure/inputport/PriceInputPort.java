package com.jaimelucas.inditex.prices.infrastructure.inputport;

import com.jaimelucas.inditex.prices.application.response.PriceDTO;

public interface PriceInputPort {

    PriceDTO getByBrandAndProductAndDate(String dateTime, Long productId, Integer brandId);
}
