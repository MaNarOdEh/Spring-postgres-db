package com.example.demo.exceptions;

import java.net.URI;

import org.zalando.problem.AbstractThrowableProblem;
import org.zalando.problem.Status;

public class MovieNotFoundException extends AbstractThrowableProblem {
    private static final URI TYPE = URI.create("https://example.org/not-found");

    public MovieNotFoundException(String movieId) {
        super(TYPE, "Not found", Status.NOT_FOUND, String.format("movie '%s' not found", movieId));
    }
}