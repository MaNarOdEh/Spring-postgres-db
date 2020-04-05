package com.example.demo.handler;

import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.zalando.problem.spring.web.advice.security.SecurityAdviceTrait;

@RestControllerAdvice
public class SecurityExceptionHandler implements SecurityAdviceTrait {

}