package com.example.demo.services.servicesInterface;

import java.util.List;
import java.util.UUID;

import com.example.demo.model.Movie;

public interface MovieServices {

    public boolean addMovie(Movie movie);

    public void deleteMovie(UUID personId, String movieId);

    public void deleteMovieById(UUID id);

    public List<Movie> getUserMovie(UUID userId);

    public List<Movie> getMoviesStartWithChars(UUID userId, Character ch);

    public List<Movie> getUserMovies(UUID userId, Integer pageNo, Integer pageSize, String sortBy);
}