package com.example.demo.validators;

import com.example.demo.model.Person;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component("beforeCreateEventPersonValidator")
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