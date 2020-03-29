package com.example.demo.deo;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.example.demo.model.Person;

public interface UserDeo {
    int insertUser(UUID id, Person user);

    default int insertUser(Person user) {
        UUID id = UUID.randomUUID();
        return insertUser(id, user);
    }

    List<Person> selectAllUsers();

    Optional<Person> selectUserById(UUID id);

    int deleteUser(UUID id);

    int updateUser(UUID id, Person user);
}