package com.example.demo.validator;

import com.example.demo.model.Person;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class PersonValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        Person user = (Person) target;
        if (checkInputString(user.getUserName())) {
            errors.rejectValue("name", "name.empty");
        }

        if (checkInputString(user.getUserPassword())) {
            errors.rejectValue("email", "email.empty");
        }

    }

    private boolean checkInputString(String input) {
        return (input == null || input.trim().length() == 0);
    }
}