package com.example.demo.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.example.demo.deo.UserDeo;
import com.example.demo.model.Person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class UserServices {

    public final UserDeo userDeo;

    @Autowired
    public UserServices(@Qualifier("postgres") UserDeo userDeo) {
        this.userDeo = userDeo;
    }

    public int addUser(Person user) {
        return userDeo.insertUser(user);
    }

    public List<Person> selectAllUsers() {
        return userDeo.selectAllUsers();
    }

    public int deleteUser(UUID id) {
        return userDeo.deleteUser(id);
    }

    public Optional<Person> getUserById(UUID id) {
        return userDeo.selectUserById(id);
    }

    public int updateUserById(UUID id, Person user) {
        return userDeo.updateUser(id, user);
    }
}