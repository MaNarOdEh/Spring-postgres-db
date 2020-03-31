package com.example.demo.deo;

import java.util.UUID;

import com.example.demo.model.Person;

import org.springframework.data.repository.CrudRepository;

public interface PersonRepository extends CrudRepository<Person, UUID> {

}