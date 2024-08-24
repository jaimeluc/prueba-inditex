package com.jaimelucas.inditex.prices.infrastructure.outputadapter;

import com.jaimelucas.inditex.prices.application.mapper.PriceMapper;
import com.jaimelucas.inditex.prices.application.response.PriceDTO;
import com.jaimelucas.inditex.prices.infrastructure.outputport.PriceEntity;
import com.jaimelucas.inditex.prices.infrastructure.outputport.PriceRepository;
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

    @Override
    public List<PriceDTO> getByBrandAndProductAndDate(Integer brandId, Long productId, LocalDateTime applicationDate) {

        List<PriceEntity> priceEntity = priceRepository.findByDateAndProductAndBrand(brandId, productId, applicationDate);

        return priceEntity.stream().map(mapper::entityToDto).toList();

    }


}
