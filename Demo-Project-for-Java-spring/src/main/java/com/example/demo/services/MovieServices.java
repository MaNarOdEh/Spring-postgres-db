package com.example.demo.services;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import com.example.demo.model.Movie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.repository.MovieRepository;
import com.example.demo.services.servicesInterface.MovieServicesInt;

@Service
public class MovieServices implements MovieServicesInt {
    @Autowired
    private MovieRepository movieRepository;

    @Override
    public boolean addMovie(Movie movie) {
        return movieRepository.save(movie) != null;
    }

    @Override
    public void deleteMovie(UUID personId, String movieId) {
        movieRepository.deleteByPersonIdAndMovieId(personId, movieId);
    }

    @Override
    public void deleteMovieById(UUID id) {
        movieRepository.deleteById(id);
    }

    @Override
    public List<Movie> getUserMovie(UUID userId) {
        return movieRepository.findByPersonId(userId);
    }

    public List<Movie> getMoviesStartWithChars(UUID userId, Character ch) {
        List<Movie> movie = movieRepository.findByPersonId(userId);
        return movie.stream().filter(mov -> mov.getMovieId().startsWith("s")).collect(Collectors.toList());
    }

}