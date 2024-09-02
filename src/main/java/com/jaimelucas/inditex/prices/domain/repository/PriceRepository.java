package com.jaimelucas.inditex.prices.domain.repository;

import com.jaimelucas.inditex.prices.domain.model.Price;

import java.time.LocalDateTime;
import java.util.List;

public interface PriceRepository {

    List<Price> findByDateAndProductAndBrand(LocalDateTime date, Long productId, Integer brandId);
}
