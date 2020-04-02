package com.example.demo.handler;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class MovieExceptionHandler {
    /*
     * @ExceptionHandler
     * 
     * @ResponseBody public String handleMovieException(Exception e) { return new
     * String("Movie Wrong!!" + e.getMessage()); }
     */
}