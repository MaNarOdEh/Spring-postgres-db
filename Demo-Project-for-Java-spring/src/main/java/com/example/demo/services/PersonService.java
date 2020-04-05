package com.example.demo.services;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import com.example.demo.model.Person;
import com.example.demo.repository.PersonRepository;
import com.example.demo.services.servicesInterface.PersonServicesInt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class PersonService implements UserDetailsService, PersonServicesInt {
    @Autowired
    private PersonRepository personRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Person person = personRepository.findByUserName(username);
        if (person == null) {
            throw new UsernameNotFoundException("user Not Found!!");
        }
        return person;
    }

    @Bean
    private PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    public void save(Person person) {
        person.setUserPassword(passwordEncoder().encode(person.getPassword()));
        this.personRepository.save(person);
    }

    @Override
    public List<Person> findAll() {
        List<Person> users = new ArrayList<>();
        this.personRepository.findAll().forEach(users::add);
        return users;
    }

    @Override
    public void deleteById(UUID id) {
        this.personRepository.deleteById(id);
    }

    @Override
    public Person findById(UUID id) {
        return this.personRepository.findById(id).orElse(null);
    }

    @Override
    public List<String> getAllPersonNames() {
        List<Person> person = findAll();
        return person.stream().map(p -> p.getUserName()).sorted().collect(Collectors.toList());
    }

    @Override
    public List<Person> getAllUserThatDoesNotHaveAnyFavouriteMovie() {
        List<Person> person = findAll();
        return person.stream().filter(p -> p.getMovies().size() == 0).collect(Collectors.toList());
    }

}