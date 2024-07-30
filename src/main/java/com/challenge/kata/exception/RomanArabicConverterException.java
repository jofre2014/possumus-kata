package com.challenge.kata.exception;

import org.springframework.http.HttpStatus;

public class RomanArabicConverterException extends BasicApiException{
    public RomanArabicConverterException(String message) {
        super(HttpStatus.INTERNAL_SERVER_ERROR, message);
    }
}
