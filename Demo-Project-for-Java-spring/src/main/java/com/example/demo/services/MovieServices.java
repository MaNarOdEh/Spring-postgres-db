package com.example.demo.services;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.example.demo.model.Movie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.deo.MovieRepository;

@Service
public class MovieServices {
    @Autowired
    private MovieRepository movieRepository;

    public boolean addMovie(Movie movie) {
        return movieRepository.save(movie) != null;
    }

    public void deleteMovie(Movie movie) {
        movieRepository.delete(movie);
    }

    public List<Movie> getUserMovie(UUID userId) {
        List<Movie> movie = new ArrayList<>();
        movieRepository.findAll().forEach(movie::add);
        return movie;
    }

}