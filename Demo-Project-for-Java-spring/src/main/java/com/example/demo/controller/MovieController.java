package com.example.demo.controller;

import java.util.List;
import java.util.UUID;

import com.example.demo.model.Movie;
import com.example.demo.model.Person;
import com.example.demo.services.MovieServicesImp;
import com.example.demo.services.PersonServiceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/favMovie")
public class MovieController {

    @Autowired
    private MovieServicesImp movieServices;
    @Autowired
    private PersonServiceImp personServiceImp;

    @PostMapping("/addMovie")
    @CrossOrigin(origins = "http://localhost:4200")
    public void addMoviewithId(@RequestBody Movie movie) {
        movieServices.addMovie(movie);
    }

    @PostMapping("/add")
    @CrossOrigin(origins = "http://localhost:4200")
    public void addMovie(@RequestBody Movie movie) {
        System.out.println(movie.getPerson().getUserName());
        Person person = (Person) personServiceImp.loadUserByUsername(movie.getPerson().getUserName());
        System.out.println(person.getUserName() + "  " + person.getId());
        movie.setPerson(person);
        movieServices.addMovie(movie);
    }

    @GetMapping("userId/{userId}")
    @CrossOrigin(origins = "http://localhost:4200")
    public List<Movie> getMovies(@PathVariable("userId") UUID userId) {
        return movieServices.getUserMovie(userId);
    }

    @GetMapping("{username}")
    @CrossOrigin(origins = "http://localhost:4200")
    public List<String> getMoviesId(@PathVariable("username") String username) {
        Person person = (Person) personServiceImp.loadUserByUsername(username);
        return movieServices.getMovieId(person.getId());
    }

    @GetMapping("sorted/{userId}")
    public List<Movie> getMovies(@RequestParam(defaultValue = "0") Integer pageNo,
            @RequestParam(defaultValue = "10") Integer pageSize, @RequestParam(defaultValue = "id") String sortBy,
            @PathVariable("userId") UUID userId) {
        return movieServices.getUserMovies(userId, pageNo, pageSize, sortBy);
    }

    @GetMapping("{id}/startwithchar/{ch}")
    public List<Movie> getMoviesStartWithChars(@PathVariable("id") UUID id, @PathVariable("ch") Character ch) {
        return movieServices.getMoviesStartWithChars(id, ch);
    }

    @DeleteMapping()
    public void deleteMovie(@RequestBody Movie movie) {
        movieServices.deleteMovie(movie.getPerson().getId(), movie.getMovieId());
    }

    @DeleteMapping("/{username}/{movieid}")
    @CrossOrigin(origins = "http://localhost:4200")
    public void deleteMovie(@PathVariable("username") String username, @PathVariable("movieid") String movieid) {
        Person person = (Person) personServiceImp.loadUserByUsername(username);
        movieServices.deleteMovie(person.getId(), movieid);
    }

    /**
     * This method will take userId & movieId and try to delete the row in DB that
     * have the same userId & movieId it will Throw :
     * 
     * MovieNotFoundException =>in case the movie is Not Found
     * 
     * @param userId
     * @param movieId
     * 
     */
    @DeleteMapping("{idUser}/movies/{movieId}")
    public void deleteMovie(@PathVariable("idUser") UUID userId, @PathVariable("movieId") String movieId) {
        movieServices.deleteMovie(userId, movieId);
    }

    @DeleteMapping("{id}")
    public void deleteMovie(@PathVariable("id") UUID id) {
        movieServices.deleteMovieById(id);
    }

}