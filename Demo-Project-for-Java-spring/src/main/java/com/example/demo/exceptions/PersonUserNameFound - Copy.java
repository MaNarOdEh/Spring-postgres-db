package com.example.demo.exceptions;

import java.net.URI;

import org.zalando.problem.AbstractThrowableProblem;
import org.zalando.problem.Status;

public class PersonUserNameFound extends AbstractThrowableProblem {
    private static final URI TYPE = URI.create("https://api/user/signup");

    public PersonUserNameFound(String userName) {
        super(TYPE, "User Name  is Used", Status.FOUND, String.format("user '%s' can't added", userName));
    }
}