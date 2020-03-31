package com.example.demo.api;

import java.util.List;
import java.util.UUID;

import com.example.demo.model.Movie;
import com.example.demo.services.MovieServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/favMovie")
public class MovieController {
    @Autowired
    private MovieServices movieServices;

    @GetMapping("{id}")
    public List<Movie> getMovies(@PathVariable("id") UUID userId) {
        System.out.println(movieServices.getUserMovie(userId).size());
        return movieServices.getUserMovie(userId);
    }

    @PostMapping("/add")
    public void addMovie(@RequestBody Movie movie) {
        movieServices.addMovie(movie);
    }

    @DeleteMapping()
    public void deleteMovie(@RequestBody Movie movie) {
        movieServices.deleteMovie(movie.getPerson().getId(), movie.getMovieId());
    }

    @DeleteMapping("{idUser}/movies/{movieId}")
    public void deleteMovie(@PathVariable("idUser") UUID userId, @PathVariable("movieId") String movieId) {
        movieServices.deleteMovie(userId, movieId);
    }

    @DeleteMapping("{id}")
    public void deleteMovie(@PathVariable("id") UUID id) {
        movieServices.deleteMovieById(id);
    }
}