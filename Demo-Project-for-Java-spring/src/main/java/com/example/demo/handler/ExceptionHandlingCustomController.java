package com.example.demo.handler;

import com.example.demo.exceptions.ExceededTheLimitForAddingMoviesToFavorites;
import com.example.demo.exceptions.MovieNotFoundException;
import com.example.demo.exceptions.PersonNotFoundException;
import com.example.demo.exceptions.PersonUserNameFound;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.zalando.problem.spring.web.advice.ProblemHandling;

@RestControllerAdvice
public class ExceptionHandlingCustomController implements ProblemHandling {
    @ExceptionHandler
    public String handleMovieNotFoundException(MovieNotFoundException exception) {
        return new ApiError(exception.getMessage()).getMessage();
    }

    @ExceptionHandler
    public String handleExceededTheLimitForAddingMoviesToFavorites(
            ExceededTheLimitForAddingMoviesToFavorites exception) {
        return new ApiError(exception.getMessage()).getMessage();
    }

    @ExceptionHandler
    public String handlePersonUserNameFound(PersonUserNameFound exception) {
        return new ApiError(exception.getMessage()).getMessage();
    }

    @ExceptionHandler
    public String handlePersonNotFoundException(PersonNotFoundException exception) {
        return new ApiError(exception.getMessage()).getMessage();
    }

}