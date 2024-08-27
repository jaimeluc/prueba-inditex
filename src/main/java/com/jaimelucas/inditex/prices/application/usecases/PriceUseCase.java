package com.jaimelucas.inditex.prices.application.usecases;


import com.jaimelucas.inditex.prices.application.response.PriceDTO;
import com.jaimelucas.inditex.prices.infrastructure.outputport.PriceRepository;
import com.jaimelucas.inditex.prices.domain.PriceDomain;
import com.jaimelucas.inditex.prices.infrastructure.inputport.PriceInputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
public class PriceUseCase implements PriceInputPort {

    private final PriceRepository priceRepository;
    private final PriceDomain priceDomain;

    @Autowired
    public PriceUseCase(PriceRepository priceRepository, PriceDomain priceDomainService) {
        this.priceRepository = priceRepository;
        this.priceDomain = priceDomainService;
    }

    @Override
    public PriceDTO getByBrandAndProductAndDate(String applicationDate, Long productId, Integer brandId) {

        // Convert date using domain service
        LocalDateTime dateTime = priceDomain.parseApplicationDate(applicationDate);

        // Retrieves prices from repository
        List<PriceDTO> priceDTOList = priceRepository.getByBrandAndProductAndDate(brandId, productId, dateTime);

        // Ensure prices exists
        priceDomain.ensurePricesExist(priceDTOList);

        // Select the highest priority price
        return priceDomain.findHighestPriorityPrice(priceDTOList);
    }
}