package com.udemy.currencyexchangeservice.handler;

public class InvalidHeaderFileException extends RuntimeException {
    private String INVALID_REQUEST="";

    public InvalidHeaderFileException(String invalid_request) {
        this.INVALID_REQUEST = invalid_request;
    }

    public String getMessage(){
        return INVALID_REQUEST;
    }
}
