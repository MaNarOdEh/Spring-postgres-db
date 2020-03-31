package com.example.demo.util;

import com.example.demo.model.Person;
import com.example.demo.services.PersonService;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class FirstTimeInitializer implements CommandLineRunner {

    private final Log logger = LogFactory.getLog(FirstTimeInitializer.class);

    @Autowired
    private PersonService personService;

    @Override
    public void run(String... args) throws Exception {
        if (personService.findAll().isEmpty()) {
            logger.info("No User Account Found ,lets Create Some User");
            this.personService.save(new Person("MaNar OdEh", "password"));
            this.personService.save(new Person("ReEm OdEh", "password"));
        }
    }

}