package com.example.demo.handler;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class PersonExceptionHandler {
    @ExceptionHandler
    public String handleInValidField(Exception exc) {
        return new String("invalid Field");
    }
}