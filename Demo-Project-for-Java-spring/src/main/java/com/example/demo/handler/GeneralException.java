package com.example.demo.handler;

import org.springframework.core.env.MissingRequiredPropertiesException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GeneralException {

    @ExceptionHandler
    public String handleMissingRequirePropertryException(MissingRequiredPropertiesException exc) {
        return exc.getMessage();
    }

    @ExceptionHandler
    public String handleUnSupportedException(UnsupportedOperationException exception) {
        return exception.getMessage();
    }

}