package com.example.demo.handler;

import com.example.demo.exceptions.MovieNotFoundException;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.zalando.problem.spring.web.advice.ProblemHandling;

@RestControllerAdvice
public class HandleCustomException implements ProblemHandling {
    @ExceptionHandler
    public String handleMovieNotFoundException(MovieNotFoundException exception) {
        return exception.getMessage();
    }

}