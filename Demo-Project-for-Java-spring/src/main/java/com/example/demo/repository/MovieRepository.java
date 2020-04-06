package com.example.demo.repository;

import java.util.List;
import java.util.UUID;

import com.example.demo.model.Movie;
import com.example.demo.model.Person;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, UUID> {

    List<Movie> findByPersonId(UUID userId);

    Page<Movie> findByPersonId(UUID userId, Pageable Pageable);

    List<Movie> findByPerson(Person user);

    int deleteByPersonIdAndMovieId(UUID userId, String movieId);

}