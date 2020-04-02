package com.example.demo.handler;

import com.example.demo.exceptions.MisingRequiredFieldException;
import com.example.demo.exceptions.PersonNotFoundException;

import org.springframework.core.env.MissingRequiredPropertiesException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class PersonExceptionHandler {
    @ExceptionHandler
    public ResponseEntity<Object> handleMissingRequiredField(MisingRequiredFieldException exc) {
        return new ResponseEntity<>("Missing Required Field ", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    public String handleMissingRequirePropertryException(MissingRequiredPropertiesException exc) {
        return exc.getMessage();
    }

    @ExceptionHandler
    public String handlePersonNotFoundException(PersonNotFoundException exception) {
        return exception.getMessage();
    }

    @ExceptionHandler
    public String handleUserNotFoundException(UsernameNotFoundException usernameNotFoundException_Exceptio) {
        return new String("Error " + usernameNotFoundException_Exceptio.getMessage());
    }
    // MissingRequiredFieldException, RecordExistsException, handleEntityNotFound
}