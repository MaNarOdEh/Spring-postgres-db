package com.example.demo.controller;

import com.example.demo.model.Person;
import com.example.demo.model.SignInRequest;
import com.example.demo.security.JwtResponse;
import com.example.demo.security.JwtTokenUtil;
import com.example.demo.services.PersonService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*
 * class       : AuthController 
 * Attributes  : TokenUtil, AuthenticationManager, PersonService
 * Responsible : This controller is only reponsible in signIn operation 
 * Methods     : 
 *  signIn:
 *         Return JwtResponse
*/
@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {
    @Autowired
    private JwtTokenUtil tokenUtil;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private PersonService personService;

    @PostMapping(value = { "", "/" })
    public JwtResponse signIn(@RequestBody SignInRequest signInRequest) {

        final Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(signInRequest.getUserName(), signInRequest.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);

        UserDetails userDetails = personService.loadUserByUsername(signInRequest.getUserName());
        String token = tokenUtil.generateToken(userDetails);
        JwtResponse jwtResponse = new JwtResponse(token);
        return jwtResponse;

    }

    @GetMapping()
    public String getHey() {
        return "hey!";
    }

}