package com.example.demo.handler;

import javax.validation.ConstraintViolationException;

import com.example.demo.exceptions.ExceededTheLimitForAddingMoviesToFavorites;
import com.example.demo.exceptions.MovieNotFoundException;
import com.example.demo.exceptions.PersonNotFoundException;
import com.example.demo.exceptions.PersonUserNameFound;

import org.springframework.core.env.MissingRequiredPropertiesException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.zalando.problem.spring.web.advice.ProblemHandling;

@RestControllerAdvice
public class ExceptionHandlingController implements ProblemHandling {
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

}