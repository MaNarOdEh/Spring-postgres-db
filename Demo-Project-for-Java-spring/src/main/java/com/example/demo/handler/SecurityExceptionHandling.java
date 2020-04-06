package com.example.demo.handler;

import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.zalando.problem.spring.web.advice.ProblemHandling;
import org.zalando.problem.spring.web.advice.security.SecurityAdviceTrait;

import static org.apiguardian.api.API.Status.INTERNAL;

import org.apiguardian.api.API;

@API(status = INTERNAL)
@RestControllerAdvice
public class SecurityExceptionHandling implements ProblemHandling, SecurityAdviceTrait {

}