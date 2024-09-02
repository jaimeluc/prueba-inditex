package com.jaimelucas.inditex.prices.domain.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<String> handleResourceNotFoundException(ResourceNotFoundException ex) {
        return new ResponseEntity<>("Resource not found: " + ex.getMessage(), HttpStatus.NOT_FOUND);
    }


    @ExceptionHandler(DateFormatBadRequestException.class)
    public ResponseEntity<String>  handleDateFormatBadRequestException(DateFormatBadRequestException ex) {
        return new ResponseEntity<>("Invalid date format: " + ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

}
