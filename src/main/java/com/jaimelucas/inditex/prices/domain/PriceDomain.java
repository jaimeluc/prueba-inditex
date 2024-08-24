package com.jaimelucas.inditex.prices.domain;


import com.jaimelucas.inditex.prices.domain.exceptions.DateFormatBadRequestException;
import com.jaimelucas.inditex.prices.domain.exceptions.ResourceNotFoundException;
import com.jaimelucas.inditex.prices.application.response.PriceDTO;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.List;

@Component
public class PriceDomain {

    private static final String NOT_FOUND_PRICE = "Not found price with the specified parameters";
    private static final String INVALID_DATE_FORMAT = "Date format not valid. Must be yyyy-MM-dd HH.mm.ss";
    private static final String DATE_PATTERN = "yyyy-MM-dd HH.mm.ss";

    public LocalDateTime parseApplicationDate(String applicationDate) {
        try {
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(DATE_PATTERN);
            return LocalDateTime.parse(applicationDate, dateTimeFormatter);
        } catch (Exception ex) {
            throw new DateFormatBadRequestException(INVALID_DATE_FORMAT);
        }
    }

    public PriceDTO findHighestPriorityPrice(List<PriceDTO> priceDTOList) {
        return priceDTOList.stream()
                .max(Comparator.comparingLong(PriceDTO::getPriority))
                .orElseThrow(() -> new ResourceNotFoundException(NOT_FOUND_PRICE));
    }

    public void ensurePricesExist(List<PriceDTO> priceDTOList) {
        if (priceDTOList.isEmpty()) {
            throw new ResourceNotFoundException(NOT_FOUND_PRICE);
        }
    }
}
