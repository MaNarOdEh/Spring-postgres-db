package com.example.demo.deo;

import java.util.List;
import java.util.UUID;

import com.example.demo.model.Movie;
import com.example.demo.model.User;

import org.springframework.data.repository.CrudRepository;

public interface MovieRepository extends CrudRepository<Movie, UUID> {
    List<Movie> findByUserId(UUID userId);

    List<Movie> findByUser(User user);

    void deleteByUserIdAndMovieId(UUID userId, String movieId);
}