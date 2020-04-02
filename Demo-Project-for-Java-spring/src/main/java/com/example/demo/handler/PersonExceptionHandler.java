package com.example.demo.handler;

import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class PersonExceptionHandler {
    @ExceptionHandler
    public String handleInValidField(Exception exc) {
        return new String(exc.getMessage());
    }

    public String handleUserNotfoundException(UsernameNotFoundException usernameNotFoundException_Exceptio) {
        return new String("User Not found !,Bad Credentails");
    }
}