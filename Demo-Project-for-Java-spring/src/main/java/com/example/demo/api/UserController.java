package com.example.demo.api;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.validation.Valid;

import com.example.demo.deo.UserRepository;
import com.example.demo.model.User;

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

    private final UserRepository userServices;

    @Autowired
    public UserController(UserRepository userServices) {
        this.userServices = userServices;
    }

    @PostMapping("/signup")
    public void addUser(@Valid @NonNull @RequestBody User user) {
        userServices.save(user);
    }

    @GetMapping({ "/", "" })
    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        userServices.findAll().forEach(users::add);
        return users;

    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable("id") UUID id) {
        return userServices.findById(id).orElse(null);
    }

    @DeleteMapping({ "/{id}" })
    public void deleteUser(@PathVariable("id") UUID id) {
        userServices.deleteById(id);
    }

    @PutMapping("/{id}")
    public void updateUser(@PathVariable("id") UUID id, @Valid @NonNull @RequestBody User user) {
        // userServices.updateUser(id, user);
    }

}