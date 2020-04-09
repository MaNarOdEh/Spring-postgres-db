package com.example.demo.controller;

import java.util.List;
import java.util.UUID;

import javax.validation.Valid;

import com.example.demo.model.Person;
import com.example.demo.services.PersonServiceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class PersonController {

    @Autowired
    private PersonServiceImp personService;

    @PostMapping("/signup")
    public void addUser(@Valid @NonNull @RequestBody Person user) {
        this.personService.save(user);
    }

    @GetMapping({ "/", "" })
    public List<Person> getAllUsers() {
        return this.personService.findAll();
    }

    @GetMapping("/userId/{id}")
    public Person getUserById(@PathVariable("id") UUID id) {
        return this.personService.findById(id);
    }

    @DeleteMapping({ "/{id}" })
    public void deleteUser(@PathVariable("id") UUID id) {
        this.personService.deleteById(id);
    }

    @PutMapping("/{id}")
    public void updateUser(@PathVariable("id") UUID id, @Valid @NonNull @RequestBody Person user) {
        user.setId(id);
        this.personService.updatePerson(user);
    }

    @GetMapping("/getSortedPersonName")
    public List<String> getAllNames() {
        return this.personService.getAllPersonNames();
    }

    @GetMapping("/userswithoutFavMovie")
    public List<Person> getAllUserThatDoesNotHaveAnyFavouriteMovie() {
        return this.personService.getAllUserThatDoesNotHaveAnyFavouriteMovie();
    }

    @GetMapping("/{username}")
    public UUID getPersonByUserName(@PathVariable("username") String userName) {
        UserDetails userDetails = this.personService.loadUserByUsername(userName);
        return userDetails != null ? ((Person) userDetails).getId() : null;
    }

}