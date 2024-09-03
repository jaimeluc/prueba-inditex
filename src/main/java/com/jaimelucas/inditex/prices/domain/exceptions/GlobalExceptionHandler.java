package com.jaimelucas.inditex.prices.domain.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    /**
     * Handle resource not found exception and return a ResponseEntity with a message and HTTP status.
     *
     * @param  ex   the ResourceNotFoundException instance
     * @return      a ResponseEntity containing the error message and HTTP status NOT_FOUND
     */
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<String> handleResourceNotFoundException(ResourceNotFoundException ex) {
        return new ResponseEntity<>("Resource not found: " + ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    /**
     * Handle date format bad request exception and return a ResponseEntity with a message and HTTP status.
     *
     * @param  ex   the DateFormatBadRequestException instance
     * @return      a ResponseEntity containing the error message and HTTP status BAD_REQUEST
     */
    @ExceptionHandler(DateFormatBadRequestException.class)
    public ResponseEntity<String>  handleDateFormatBadRequestException(DateFormatBadRequestException ex) {
        return new ResponseEntity<>("Invalid date format: " + ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

}
