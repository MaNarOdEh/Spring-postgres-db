package com.example.demo.exceptions;

import java.net.URI;

import org.zalando.problem.AbstractThrowableProblem;
import org.zalando.problem.Status;

public class PersonNotFoundException extends AbstractThrowableProblem {
    private static final URI TYPE = URI.create("https://example.org/not-found");

    public PersonNotFoundException(String personInfo) {
        super(TYPE, "Not found", Status.NOT_FOUND, String.format("person '%s' not found", personInfo));
    }
}