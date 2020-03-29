package com.example.demo.model;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
    /*
     * @Getter
     * 
     * @Setter
     * 
     * @Column(name = "userId") private UUID userId;
     */

    @ManyToOne(fetch = FetchType.LAZY)

    @JoinColumn(name = "user_id")

    @NotBlank

    @Getter

    @Setter
    private User user;

    public Movie(String movieId, User user) {
        if (this.id == null)
            this.id = UUID.randomUUID();
        // this.movieId = movieId;
        this.user = user;
    }

    public Movie() {

    }

}