package com.jaimelucas.inditex.prices.application;

import com.jaimelucas.inditex.prices.domain.exceptions.DateFormatBadRequestException;
import com.jaimelucas.inditex.prices.domain.exceptions.ResourceNotFoundException;
import com.jaimelucas.inditex.prices.domain.model.Price;
import com.jaimelucas.inditex.prices.domain.repository.PriceRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.List;

@Service
@AllArgsConstructor
public class GetPriceUseCase {

    private final PriceRepository priceRepository;


    /**
     * @param date
     * @param productId
     * @param brandId
     * @return
     */

    public Price getPriceById(String date, Long productId, Integer brandId) {


        LocalDateTime parsedDate = parseApplicationDate(date);

        List<Price> priceList = priceRepository.findByDateAndProductAndBrand(parsedDate, productId, brandId);

        Price highestPrice = findHighestPriorityPrice(priceList);

        ensurePricesExist(priceList);

        return highestPrice;
    }


    private Price findHighestPriorityPrice(List<Price> priceList) {
        return priceList.stream()
                .max(Comparator.comparingLong(Price::getPriority))
                .orElseThrow(() -> new ResourceNotFoundException("Not found price with the specified parameters"));
    }


    private void ensurePricesExist(List<Price> priceList) {
        if (priceList.isEmpty()) {
            throw new ResourceNotFoundException("Not found price with the specified parameters");
        }
    }

    private LocalDateTime parseApplicationDate(String applicationDate) {
        try {
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH.mm.ss");
            return LocalDateTime.parse(applicationDate, dateTimeFormatter);
        } catch (Exception ex) {
            throw new DateFormatBadRequestException("Date format not valid. Must be yyyy-MM-dd HH.mm.ss");
        }
    }
}
