package com.example.demo.exceptions;

import java.net.URI;

import org.zalando.problem.AbstractThrowableProblem;
import org.zalando.problem.Status;

public class MovieEntityFound extends AbstractThrowableProblem {
    private static final URI TYPE = URI.create("https://movies/add/movie");

    public MovieEntityFound(String movieId) {
        super(TYPE, "Movie Id is Found", Status.FOUND, String.format("movie '%s' can't add", movieId));
    }
}