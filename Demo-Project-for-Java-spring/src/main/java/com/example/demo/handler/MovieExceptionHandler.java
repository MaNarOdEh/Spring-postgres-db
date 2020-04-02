package com.example.demo.handler;

import com.example.demo.exceptions.MovieNotFoundException;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class MovieExceptionHandler {
    @ExceptionHandler
    @ResponseBody
    public String handleMovieNotFoundException(MovieNotFoundException exception) {
        return exception.getMessage();
    }
}