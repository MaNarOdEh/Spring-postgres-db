package com.example.demo.exceptions;

import java.net.URI;

import com.example.demo.model.Movie;

import org.zalando.problem.AbstractThrowableProblem;
import org.zalando.problem.Status;

public class ExceededTheLimitForAddingMoviesToFavorites extends AbstractThrowableProblem {
    private static final URI TYPE = URI.create("https://movies/add/movie");

    public ExceededTheLimitForAddingMoviesToFavorites(String movieId) {
        super(TYPE, "Exceeded the limit", Status.BANDWIDTH_LIMIT_EXCEEDED,
                String.format("movie '%s' can't add", movieId));
    }
}