/*package com.jaimelucas.inditex.prices.domain;

import com.jaimelucas.inditex.prices.infrastructure.dtos.PriceDTO;
import com.jaimelucas.inditex.prices.domain.exceptions.DateFormatBadRequestException;
import com.jaimelucas.inditex.prices.domain.exceptions.ResourceNotFoundException;
import org.junit.Test;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class PriceDomainTest {

    private final PriceDomain priceDomain = new PriceDomain();

    @Test
    public void parseApplicationDate_ValidDate_ShouldReturnLocalDateTime() {
        String dateStr = "2024-08-26 15.30.00";
        LocalDateTime expectedDate = LocalDateTime.of(2024, 8, 26, 15, 30, 0);

        LocalDateTime result = priceDomain.parseApplicationDate(dateStr);

        assertEquals(expectedDate, result);
    }

    @Test
    public void parseApplicationDate_InvalidDateFormat_ShouldThrowDateFormatBadRequestException() {
        String invalidDateStr = "26-08-2024 15:30:00";

        DateFormatBadRequestException exception = assertThrows(DateFormatBadRequestException.class, () ->
                priceDomain.parseApplicationDate(invalidDateStr)
        );

        assertEquals("Date format not valid. Must be yyyy-MM-dd HH.mm.ss", exception.getMessage());
    }

    @Test
    public void findHighestPriorityPrice_ValidList_ShouldReturnPriceDTOWithHighestPriority() {


        PriceDTO price1 = PriceDTO.builder()
                .productId(1L)
                .startDate("2020-06-15T16:00:00")
                .endDate("2020-07-15T16:00:00")
                .priceList(1L)
                .priority(1L)
                .currency("EUR")
                .price(1.0)
                .brandId(1)
                .build();
        PriceDTO price2 = PriceDTO.builder()
                .productId(1L)
                .startDate("2020-06-15T16:00:00")
                .endDate("2020-07-15T16:00:00")
                .priceList(1L)
                .priority(2L)
                .currency("EUR")
                .price(1.0)
                .brandId(1)
                .build();

        List<PriceDTO> priceList = Arrays.asList(price1, price2);

        PriceDTO result = priceDomain.findHighestPriorityPrice(priceList);

        assertEquals(price2, result);
    }

    @Test
    public void findHighestPriorityPrice_EmptyList_ShouldThrowResourceNotFoundException() {
        List<PriceDTO> emptyList = List.of();

        ResourceNotFoundException exception = assertThrows(ResourceNotFoundException.class, () ->
                priceDomain.findHighestPriorityPrice(emptyList)
        );

        assertEquals("Not found price with the specified parameters", exception.getMessage());
    }

    @Test
    public void ensurePricesExist_NonEmptyList_ShouldNotThrowException() {
        PriceDTO price = PriceDTO.builder().build();
        List<PriceDTO> priceList = Arrays.asList(price);

        assertDoesNotThrow(() -> priceDomain.ensurePricesExist(priceList));
    }

    @Test
    public void ensurePricesExist_EmptyList_ShouldThrowResourceNotFoundException() {
        List<PriceDTO> emptyList = List.of();

        ResourceNotFoundException exception = assertThrows(ResourceNotFoundException.class, () ->
                priceDomain.ensurePricesExist(emptyList)
        );

        assertEquals("Not found price with the specified parameters", exception.getMessage());
    }
}*/