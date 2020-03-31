package com.example.demo.services;

import java.util.List;
import java.util.UUID;

import com.example.demo.model.Movie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.repository.MovieRepository;

@Service
public class MovieServices {
    @Autowired
    private MovieRepository movieRepository;

    public boolean addMovie(Movie movie) {
        return movieRepository.save(movie) != null;
    }

    public void deleteMovie(UUID personId, String movieId) {
        movieRepository.deleteByPersonIdAndMovieId(personId, movieId);
    }

    public void deleteMovieById(UUID id) {
        movieRepository.deleteById(id);
    }

    public List<Movie> getUserMovie(UUID userId) {
        return movieRepository.findByPersonId(userId);
    }

}