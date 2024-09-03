package com.jaimelucas.inditex.prices.application;

import com.jaimelucas.inditex.prices.domain.model.Price;
import com.jaimelucas.inditex.prices.domain.repository.PriceRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

class GetPriceUseCaseTest {


    @Mock
    private PriceRepository priceRepository;

    @InjectMocks
    private GetPriceUseCase getPriceUseCase;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }


    @Test
    void testGetPriceById() {
        // create mock data
        String date = "2022-01-01 00:00:00";
        Long productId = 1L;
        Integer brandId = 1;


        Price price1 = Price.builder()
                .finalPrice(30.0)
                .brandId(1)
                .currency("EUR")
                .startDate(LocalDateTime.parse("2022-01-01T00:00:00"))
                .endDate(LocalDateTime.parse("2022-01-02T00:00:00"))
                .priority(1L)
                .productId(1L)
                .priceList(1L)
                .build();

        Price price2 = Price.builder()
                .finalPrice(30.0)
                .brandId(1)
                .currency("EUR")
                .startDate(LocalDateTime.parse("2022-01-01T00:00:00"))
                .endDate(LocalDateTime.parse("2022-01-02T00:00:00"))
                .priority(2L)
                .productId(1L)
                .priceList(1L)
                .build();


        List<Price> priceList = Arrays.asList(price1, price2);


        // mock the repository
        when(priceRepository.findByDateAndProductAndBrand(any(LocalDateTime.class),any(Long.class), any(Integer.class)))
                .thenReturn(priceList);

        // call the method
        Price result = getPriceUseCase.getPriceById(date, productId, brandId);

        // assert the result
        assertEquals(price2, result);
    }


    @Test
     void testGetPriceByIdWithInvalidDate() {
        // create mock data
        String date = "invalid date";
        Long productId = 1L;
        Integer brandId = 1;

        String exceptionMessage = "Date format not valid. Must be yyyy-MM-dd HH:mm:ss";

        try {
            // call the method
            getPriceUseCase.getPriceById(date, productId, brandId);
            fail("Expected RuntimeException to be thrown");
        } catch (RuntimeException e) {
            // Assert
            assertEquals(exceptionMessage, e.getMessage());
        }


    }

    @Test
     void testGetPriceByIdWithEmptyPriceList() {
        // create mock data
        String date = "2022-01-01 00:00:00";
        Long productId = 1L;
        Integer brandId = 1;
        List<Price> priceList = Collections.emptyList();

        // mock the repository
        when(priceRepository.findByDateAndProductAndBrand(any(LocalDateTime.class), any(Long.class), any(Integer.class))).thenReturn(priceList);

        String exceptionMessage = "Not found price with the specified parameters";

        try {
            // call the method
            getPriceUseCase.getPriceById(date, productId, brandId);
            fail("Expected RuntimeException to be thrown");
        } catch (RuntimeException e) {
            // Assert
            assertEquals(exceptionMessage, e.getMessage());
        }

    }








}