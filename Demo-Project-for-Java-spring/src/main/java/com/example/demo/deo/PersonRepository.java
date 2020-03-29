package com.example.demo.deo;

import java.util.UUID;

import com.example.demo.model.Person;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface PersonRepository extends CrudRepository<Person, UUID> {
    @Modifying
    @Query("update person p set p.username = ?1, u.password = ?2 where p.id = ?3")
    void setUserInfoById(String username, String password, UUID id);
}