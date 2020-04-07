package com.example.demo.handler;

import javax.validation.ConstraintViolationException;

import org.springframework.core.env.MissingRequiredPropertiesException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandleContoller {

    @ExceptionHandler
    public String handleMissingRequirePropertryException(MissingRequiredPropertiesException exception) {
        return new ApiError(exception.getMessage()).getMessage();
    }

    @ExceptionHandler
    public String handleUnSupportedException(UnsupportedOperationException exception) {
        return new ApiError(exception.getMessage()).getMessage();
    }

    @ExceptionHandler
    public String handleConstraintViolationException(ConstraintViolationException exception) {
        return new ApiError(exception.getMessage()).getMessage();
    }

    @ExceptionHandler
    public String handleUserNotFoundException(UsernameNotFoundException exception) {
        return new ApiError(exception.getMessage()).getMessage();

    }

    @ExceptionHandler
    public String handleException(Exception exception) {
        return new ApiError(exception.getMessage()).getMessage();
    }

}