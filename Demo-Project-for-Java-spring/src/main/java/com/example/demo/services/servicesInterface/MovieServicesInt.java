package com.example.demo.services.servicesInterface;

import java.util.List;
import java.util.UUID;

import com.example.demo.model.Movie;

public interface MovieServicesInt {

    public boolean addMovie(Movie movie);

    public void deleteMovie(UUID personId, String movieId);

    public void deleteMovieById(UUID id);

    public List<Movie> getUserMovie(UUID userId);
}