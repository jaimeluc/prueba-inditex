package com.jaimelucas.inditex.prices.infrastructure.mapper;

import com.jaimelucas.inditex.prices.domain.model.Price;
import com.jaimelucas.inditex.prices.infrastructure.persistence.PriceEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PriceMapper {

    /**
     * Maps a PriceEntity to a Price model object.
     *
     * @param  source  the PriceEntity to be mapped
     * @return         the mapped Price model object
     */
    @Mapping(target = "brandId", source = "id.brandId")
    @Mapping(target = "startDate", source = "id.startDate")
    @Mapping(target = "productId", source = "id.productId")
    @Mapping(target = "priority", source = "id.priority")
    @Mapping(target = "finalPrice", source = "price")
    Price entityToModel(PriceEntity source);


}
