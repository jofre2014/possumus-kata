package com.challenge.kata.exception;

import org.springframework.http.HttpStatus;

public class BasicApiException extends RuntimeException {
    private final HttpStatus status;
    public BasicApiException(HttpStatus status, String message) {
        super(message);
        this.status = status;
    }

    public HttpStatus getStatus() {
        return status;
    }
}
