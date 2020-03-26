package com.example.demo.deo;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.example.demo.model.User;

public interface UserDeo {
    int insertUser(UUID id, User user);

    default int insertUser(User user) {
        UUID id = UUID.randomUUID();
        return insertUser(id, user);
    }

    List<User> selectAllUsers();

    Optional<User> selectUserById(UUID id);

    int deleteUser(UUID id);

    int updateUser(UUID id, User user);
}