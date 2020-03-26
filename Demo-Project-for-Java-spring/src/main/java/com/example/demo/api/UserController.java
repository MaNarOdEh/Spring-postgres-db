package com.example.demo.api;

import java.util.List;
import java.util.UUID;

import javax.validation.Valid;

import com.example.demo.model.User;
import com.example.demo.services.UserServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
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
public class UserController {

    private final UserServices userServices;

    @Autowired
    public UserController(UserServices userServices) {
        this.userServices = userServices;
    }

    @PostMapping("/signup")
    public void addUser(@Valid @NonNull @RequestBody User user) {
        userServices.addUser(user);
    }

    @GetMapping({ "/", "" })
    public List<User> getAllUsers() {
        return userServices.selectAllUsers();
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable("id") UUID id) {
        return userServices.getUserById(id).orElse(null);
    }

    @DeleteMapping({ "/{id}" })
    public void deleteUser(@PathVariable("id") UUID id) {
        userServices.deleteUser(id);
    }

    @PutMapping("/{id}")
    public void updateUser(@PathVariable("id") UUID id, @Valid @NonNull @RequestBody User user) {
        userServices.updateUserById(id, user);
    }

}