package com.example.demo.deo;

import java.util.UUID;

import com.example.demo.model.Movie;

import org.springframework.data.repository.CrudRepository;

public interface MovieRepository extends CrudRepository<Movie, UUID> {
}