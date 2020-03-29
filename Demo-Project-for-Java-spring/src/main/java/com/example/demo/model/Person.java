package com.example.demo.model;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "person", schema = "public")
public class Person {

    @Id
    private UUID id;
    @NotBlank
    @Column(name = "username")
    private String userName;
    @NotBlank
    @Column(name = "userpassword")
    private String userPassword;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)

    @JoinColumn(name = "personid")

    @JsonIgnore
    private List<Movie> movies;

    public Person(@JsonProperty("userName") String userName, @JsonProperty("password") String password) {
        if (this.id == null) {
            this.id = UUID.randomUUID();
        }
        this.userName = userName;
        this.userPassword = password;
        this.movies = new ArrayList<>();
    }

    public Person() {

    }

    /**
     * @return the id
     */
    public UUID getId() {
        return id;
    }

    /**
     * @return the userPassword
     */
    public String getUserPassword() {
        return userPassword;
    }

    /**
     * @return the userName
     */
    public String getUserName() {
        return userName;
    }

    /**
     * @param id the id to set
     */
    public void setId(UUID id) {
        this.id = id;
    }

    /**
     * @param userPassword the userPassword to set
     */
    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    /**
     * @param userName the userName to set
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * @return the movies
     */

    public List<Movie> getMovies() {
        return movies;
    }

    /**
     * @param movies the movies to set
     */

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }

    public void addMovie(Movie movie) {
        // this.movies.add(movie);
        movie.setPerson(this);
    }

    public void removeMovie(Movie movie) {
        // this.movies.remove(movie);
        movie.setPerson(null);
    }
}