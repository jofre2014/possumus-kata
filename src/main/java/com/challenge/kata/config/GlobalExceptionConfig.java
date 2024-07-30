package com.challenge.kata.config;

import com.challenge.kata.dto.ErrorDto;
import com.challenge.kata.exception.BasicApiException;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class GlobalExceptionConfig {

    private static final String PREFIX_ERROR_CODE = "roman-arabic-converter-";


    @ExceptionHandler(value = BasicApiException.class)
    public ResponseEntity<Object> handleAllUncaughtException(
            BasicApiException ex,
            WebRequest request) {

        return generateBody(ex, ex.getStatus());
    }

    @ExceptionHandler(value = ConstraintViolationException.class)
    public ResponseEntity<Object> handleException(ConstraintViolationException ex, WebRequest request) {
        return generateBody(ex, HttpStatus.BAD_REQUEST);
    }


    private ResponseEntity<Object> generateBody(Exception ex, HttpStatus statusCode) {
        return new ResponseEntity<>(
                new ErrorDto(
                        PREFIX_ERROR_CODE + String.format("%05d", statusCode.value()),
                        ex.getMessage()
                ),
                statusCode
        );
    }
}
