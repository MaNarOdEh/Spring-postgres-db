package com.example.demo.repository;

import java.util.List;
import java.util.UUID;

import com.example.demo.model.Movie;
import com.example.demo.model.Person;

import org.springframework.data.repository.CrudRepository;

public interface MovieRepository extends CrudRepository<Movie, UUID> {

    List<Movie> findByPersonId(UUID userId);

    List<Movie> findByPerson(Person user);

    int deleteByPersonIdAndMovieId(UUID userId, String movieId);

}