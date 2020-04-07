package com.example.demo.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import com.example.demo.exceptions.PersonNotFoundException;
import com.example.demo.exceptions.PersonUserNameFound;
import com.example.demo.model.Person;
import com.example.demo.repository.PersonRepository;
import com.example.demo.services.servicesInterface.PersonServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class PersonServiceImp implements UserDetailsService, PersonServices {
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

    /**
     * 
     * @param person
     * @throws personUserNameFound when the user try to signup with a used userName
     */
    @Override
    public void save(Person person) {
        person.setUserPassword(passwordEncoder().encode(person.getPassword()));
        List<Person> persons = findAll();
        Predicate<Person> predicate = p -> p.getUserName().equals(person.getUserName());
        if (persons.stream().anyMatch(predicate)) {
            throw new PersonUserNameFound(person.getUserName());
        }
        this.personRepository.save(person);
    }

    @Override
    @Cacheable(value = "cache-person", key = "'userInfo'")
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
    @CachePut(value = "userInfo", key = "'personDetails'+#id.toString()")
    public Person findById(UUID id) {
        Optional<Person> person = this.personRepository.findById(id);
        if (!person.isPresent()) {
            throw new PersonNotFoundException(id.toString());
        }
        return person.orElse(null);
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

    @Override
    @CachePut(value = "userInfo", key = "'personDetails'+#person.getId().toString()")
    public void updatePerson(Person person) {
        person.setUserPassword(passwordEncoder().encode(person.getPassword()));
        List<Person> persons = findAll();
        Predicate<Person> predicate = p -> p.getUserName().equals(person.getUserName());
        if (!persons.stream().anyMatch(predicate)) {
            throw new PersonNotFoundException(person.getUserName());
        }
        this.personRepository.save(person);

    }

}