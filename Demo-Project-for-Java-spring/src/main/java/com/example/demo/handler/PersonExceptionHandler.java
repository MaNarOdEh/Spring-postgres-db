package com.example.demo.handler;

import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class PersonExceptionHandler {

    @ExceptionHandler
    public String handleUserNotFoundException(UsernameNotFoundException usernameNotFoundException_Exceptio) {
        return new String("Error " + usernameNotFoundException_Exceptio.getMessage());
    }
}