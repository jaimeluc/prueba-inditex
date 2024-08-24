package com.jaimelucas.inditex.prices.infrastructure.outputport;

import com.jaimelucas.inditex.prices.application.response.PriceDTO;

import java.time.LocalDateTime;
import java.util.List;

public interface PriceRepository {

    List<PriceDTO> getByBrandAndProductAndDate(Integer brandId, Long productId, LocalDateTime applicationDate);
}
