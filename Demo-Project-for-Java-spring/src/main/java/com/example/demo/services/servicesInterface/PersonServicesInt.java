package com.example.demo.services.servicesInterface;

import java.util.List;
import java.util.UUID;

import com.example.demo.model.Person;

public interface PersonServicesInt {
    public void save(Person person);

    public List<Person> findAll();

    public void deleteById(UUID id);

    public Person findById(UUID id);

    public List<String> getAllPersonNames();

    public List<Person> getAllUserThatDoesNotHaveAnyFavouriteMovie();

}