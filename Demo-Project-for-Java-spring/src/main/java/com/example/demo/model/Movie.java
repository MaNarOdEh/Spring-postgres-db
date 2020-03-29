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

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "movie", schema = "public")
@Data
public class Movie implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Setter
    @Getter
    private UUID id;
    @NotBlank
    @Setter
    @Getter
    @Column(name = "movieid")
    private String movieId;

    @NotBlank

    @Getter

    @Setter

    @ManyToOne(fetch = FetchType.LAZY)

    @JoinColumn(name = "personid", referencedColumnName = "id")

    @OnDelete(action = OnDeleteAction.CASCADE)
    private Person person;

    public Movie(String movieId) {
        super();
        this.movieId = movieId;
    }

    public Movie(String movieId, Person person) {
        if (this.id == null)
            this.id = UUID.randomUUID();
        this.person = person;
    }

    public Movie() {
        if (this.id == null)
            this.id = UUID.randomUUID();
    }

    public void setPerson(Person person) {
        this.person = person;
    }

}