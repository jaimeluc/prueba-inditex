package com.jaimelucas.inditex.prices.infrastructure.persistence;

import com.jaimelucas.inditex.prices.domain.model.Price;
import com.jaimelucas.inditex.prices.domain.repository.PriceRepository;
import com.jaimelucas.inditex.prices.infrastructure.mapper.PriceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
public class JpaPriceRepository implements PriceRepository {

    private final SpringDataJpaPriceRepository priceRepository;

    private final PriceMapper mapper;

    @Autowired
    public JpaPriceRepository(SpringDataJpaPriceRepository priceRepository, PriceMapper mapper) {
        this.priceRepository = priceRepository;
        this.mapper = mapper;
    }

    /**
     * A method to find prices by date, product, and brand.
     *
     * @param  date       the date to search for prices
     * @param  productId  the id of the product
     * @param  brandId    the id of the brand
     * @return            a list of prices matching the criteria
     */
    @Override
    public List<Price> findByDateAndProductAndBrand(LocalDateTime date, Long productId, Integer brandId) {

        List<PriceEntity> priceEntity = priceRepository.findByDateAndProductAndBrand(brandId, productId, date);

        return priceEntity.stream().map(mapper::entityToModel).toList();

    }


}
