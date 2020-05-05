package com.udemy.currencyexchangeservice.handler;

public class InvalidFieldException extends RuntimeException {
    private static final String INVALID_EXCEPTION = "Invalid Request Found";

    public String getMessage() {
        return INVALID_EXCEPTION;
    }
}
