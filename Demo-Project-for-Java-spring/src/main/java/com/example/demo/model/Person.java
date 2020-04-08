package com.example.demo.model;

import java.util.ArrayList;
import java.util.Collection;
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

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
@Table(name = "person", schema = "public")
public class Person implements UserDetails {

    @Id
    private UUID id;
    @NotBlank
    @Column(name = "username")
    private String userName;
    @NotBlank
    @Column(name = "userpassword")
    @JsonIgnore
    private String userPassword;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)

    @JoinColumn(name = "personid")

    @JsonIgnore
    private List<Movie> movies = new ArrayList<>();

    public Person(@JsonProperty("username") String userName, @JsonProperty("password") String password) {
        this();
        this.userName = userName;
        this.userPassword = password;
    }

    public Person() {
        if (this.id == null) {
            this.id = UUID.randomUUID();
        }
    }

    /**
     * @return the id
     */
    public UUID getId() {
        return this.id;
    }

    /**
     * @return the userPassword
     */
    public String getUserPassword() {
        return this.userPassword;
    }

    /**
     * @return the userName
     */
    public String getUserName() {
        return this.userName;
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
        this.movies.add(movie);
        movie.setPerson(this);
    }

    public void removeMovie(Movie movie) {
        this.movies.remove(movie);
        movie.setPerson(null);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return this.userPassword;
    }

    @Override
    public String getUsername() {
        return this.userName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

}