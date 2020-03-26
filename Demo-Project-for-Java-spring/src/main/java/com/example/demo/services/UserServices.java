package com.example.demo.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.example.demo.deo.UserDeo;
import com.example.demo.model.User;

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

    public int addUser(User user) {
        return userDeo.insertUser(user);
    }

    public List<User> selectAllUsers() {
        return userDeo.selectAllUsers();
    }

    public int deleteUser(UUID id) {
        return userDeo.deleteUser(id);
    }

    public Optional<User> getUserById(UUID id) {
        return userDeo.selectUserById(id);
    }

    public int updateUserById(UUID id, User user) {
        return userDeo.updateUser(id, user);
    }
}