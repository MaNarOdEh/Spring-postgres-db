package com.example.demo.deo;

import java.util.UUID;

import com.example.demo.model.User;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, UUID> {
}