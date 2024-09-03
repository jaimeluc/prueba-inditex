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

    public static final String NOT_FOUND_PRICE = "Not found price with the specified parameters";
    public static final String INVALID_DATE_FORMAT = "Date format not valid. Must be yyyy-MM-dd HH:mm:ss";
    public static final String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";

    private final PriceRepository priceRepository;


    /**
     * Retrieves the highest priority price for the specified date, product, and brand.
     *
     * @param  date     the date for the price query
     * @param  productId the ID of the product
     * @param  brandId  the ID of the brand
     * @return          the highest priority price for the specified date, product, and brand
     */
    public Price getPriceById(String date, Long productId, Integer brandId) {


        LocalDateTime parsedDate = parseApplicationDate(date);

        List<Price> priceList = priceRepository.findByDateAndProductAndBrand(parsedDate, productId, brandId);

        Price highestPrice = findHighestPriorityPrice(priceList);

        ensurePricesExist(priceList);

        return highestPrice;
    }


    /**
     * Finds the highest priority price in the given list of prices.
     *
     * @param  priceList  the list of prices to search
     * @return the price with the highest priority
     */
    private Price findHighestPriorityPrice(List<Price> priceList) {
        return priceList.stream()
                .max(Comparator.comparingLong(Price::getPriority))
                .orElseThrow(() -> new ResourceNotFoundException(NOT_FOUND_PRICE));
    }

    /**
     * Ensures that the list of prices is not empty.
     *
     * @param  priceList  the list of prices to check
     */
    private void ensurePricesExist(List<Price> priceList) {
        if (priceList.isEmpty()) {
            throw new ResourceNotFoundException(NOT_FOUND_PRICE);
        }
    }

    /**
     * Parses the application date string into a LocalDateTime object using the provided DATE_FORMAT.
     *
     * @param  applicationDate  the string representing the application date
     * @return                 the parsed LocalDateTime object
     */
    private LocalDateTime parseApplicationDate(String applicationDate) {
        try {
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(DATE_FORMAT);
            return LocalDateTime.parse(applicationDate, dateTimeFormatter);
        } catch (Exception ex) {
            throw new DateFormatBadRequestException(INVALID_DATE_FORMAT);
        }
    }
}
