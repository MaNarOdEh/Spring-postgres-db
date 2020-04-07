package com.example.demo.model;

import java.io.Serializable;
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
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.cache.annotation.Cacheable;

import lombok.Data;

@Entity
@Table(name = "movie", schema = "public")
@Data
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Movie implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "movieid")
    @NotBlank
    private String movieId;

    @NotNull
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "personid", referencedColumnName = "id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnoreProperties("person")
    private Person person;

    public Movie() {
        if (this.id == null) {
            this.id = UUID.randomUUID();
        }
    }

    public Movie(String movieId) {
        this();
        this.movieId = movieId;
    }

    public Movie(@JsonProperty("movieid") String movieId, @JsonProperty("person") Person person) {
        this(movieId);
        this.person = person;
        this.movieId = movieId;

    }

    public void setPerson(Person person) {
        this.person = person;
    }

    /**
     * @return the id
     */
    public UUID getId() {
        return id;
    }

    /**
     * @return the movieId
     */
    public String getMovieId() {
        return movieId;
    }

    /**
     * @return the person
     */
    public Person getPerson() {
        return person;
    }

    /**
     * @param id the id to set
     */
    public void setId(UUID id) {
        this.id = id;
    }

    /**
     * @param movieId the movieId to set
     */
    public void setMovieId(String movieId) {
        this.movieId = movieId;
    }

}