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

        // Convertir la fecha usando el servicio de dominio
        LocalDateTime dateTime = priceDomain.parseApplicationDate(applicationDate);

        // Obtener precios del repositorio
        List<PriceDTO> priceDTOList = priceRepository.getByBrandAndProductAndDate(brandId, productId, dateTime);

        // Asegurar que existan precios
        priceDomain.ensurePricesExist(priceDTOList);

        // Seleccionar el precio de mayor prioridad
        return priceDomain.findHighestPriorityPrice(priceDTOList);
    }
}