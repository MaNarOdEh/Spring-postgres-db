package com.example.demo.model;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "movie")
@Data
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Setter
    @Getter
    private UUID id;
    @NotBlank
    @Setter
    @Getter
    @Column(name = "movieId")
    private String movieId;
    @NotBlank
    @Setter
    @Getter
    @Column(name = "userId")
    private UUID userId;

    public Movie(String movieId, UUID userId) {
        if (this.id == null)
            this.id = UUID.randomUUID();
        this.movieId = movieId;
        this.userId = userId;
    }

    public Movie() {

    }

}