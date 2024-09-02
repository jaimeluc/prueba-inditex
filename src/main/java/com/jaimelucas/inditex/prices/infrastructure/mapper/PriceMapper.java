package com.jaimelucas.inditex.prices.infrastructure.mapper;

import com.jaimelucas.inditex.prices.domain.model.Price;
import com.jaimelucas.inditex.prices.infrastructure.dtos.PriceDTO;
import com.jaimelucas.inditex.prices.infrastructure.persistence.PriceEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PriceMapper {


    @Mapping(target = "brandId", source = "id.brandId")
    @Mapping(target = "startDate", source = "id.startDate")
    @Mapping(target = "productId", source = "id.productId")
    @Mapping(target = "finalPrice", source = "price")
    Price entityToModel(PriceEntity source);


}
