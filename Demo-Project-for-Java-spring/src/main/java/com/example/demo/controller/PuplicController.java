package com.example.demo.controller;

import com.example.demo.exceptions.MovieNotFoundException;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.core.env.MissingRequiredPropertiesException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/public")
public class PuplicController {
    @GetMapping
    public String sayHello() {
        return "Hello World!";
    }

    @GetMapping("/throwUnSupportedException")
    public void print() {
        throw new UnsupportedOperationException("This Operation is not allowed here!!");
    }

    @GetMapping("/throwMissingRequiredProperty")
    public void throwMissingRequiredProperty() {
        throw new MissingRequiredPropertiesException();
    }

    @GetMapping("/movieNotFound")
    public void throwMovieNotFoundException() {
        throw new MovieNotFoundException("123");
    }

    @GetMapping("/cashing")
    @Cacheable("try")
    public String tryUsingCashing() {
        try {
            System.out.println("Going to sleep for 5 Secs.. to simulate backend call.");
            Thread.sleep(1000 * 5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return new String("Number 1");
    }
}