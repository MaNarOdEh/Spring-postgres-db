package com.example.demo.exceptions;

import java.net.URI;

import org.zalando.problem.AbstractThrowableProblem;
import org.zalando.problem.Status;

public class PasswordNotMatchException extends AbstractThrowableProblem {
    private static final URI TYPE = URI.create("https://api/user/update/password");

    public PasswordNotMatchException() {
        super(TYPE, "Wrong Password", Status.FOUND, ("user password cant be updated"));
    }
}