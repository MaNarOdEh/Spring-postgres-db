package com.example.demo.repository;

import java.util.UUID;

import com.example.demo.model.Person;

import org.springframework.data.repository.CrudRepository;

public interface PersonRepository extends CrudRepository<Person, UUID> {
    Person findByUserName(String username);
}