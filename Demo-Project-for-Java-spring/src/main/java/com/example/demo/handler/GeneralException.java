package com.example.demo.handler;

import javax.validation.ConstraintViolationException;

import org.springframework.core.env.MissingRequiredPropertiesException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GeneralException {

    @ExceptionHandler
    public String handleMissingRequirePropertryException(MissingRequiredPropertiesException exc) {
        return exc.getMessage() + exc.getLocalizedMessage() + "  " + exc.getClass();
    }

    @ExceptionHandler
    public String handleUnSupportedException(UnsupportedOperationException exception) {
        return exception.getMessage();
    }

    @ExceptionHandler
    public String handleConstraintViolationException(ConstraintViolationException exception) {
        return exception.getMessage() + "  ";
    }

}