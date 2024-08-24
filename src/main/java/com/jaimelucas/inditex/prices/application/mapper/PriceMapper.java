package com.jaimelucas.inditex.prices.application.mapper;

import com.jaimelucas.inditex.prices.application.response.PriceDTO;
import com.jaimelucas.inditex.prices.infrastructure.outputport.PriceEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PriceMapper {

    @Mapping(target = "brandId", source = "id.brandId")
    @Mapping(target = "startDate", source = "id.startDate")
    @Mapping(target = "productId", source = "id.productId")
    PriceDTO entityToDto(PriceEntity source);

}
