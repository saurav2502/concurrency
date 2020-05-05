package com.udemy.currencyexchangeservice.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ApplicationExceptionHandler {
    @ExceptionHandler
    public String handleInvalidFieldException(InvalidFieldException exception){
        return exception.getMessage();
    }

    @ExceptionHandler
    public ResponseEntity<String>handleInvalidHeaderException(InvalidHeaderFileException exp) {
        return new ResponseEntity<>(exp.getMessage(), HttpStatus.PRECONDITION_FAILED);
    }
}
