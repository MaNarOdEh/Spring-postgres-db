package com.example.demo.controller;

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
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {
    @Autowired
    private JwtTokenUtil tokenUtil;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private PersonService personService;

    /**
     * signIn method
     * 
     * This method is responsible to check if the user credentials correct.
     * 
     * @param signInRequest which hold user credentials[name, password]
     * @return it will return the token for the user as an Jwt Response object. In
     *         case when the user credential is not correct it will return
     *         unAuthorized message..
     */
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

    @ExceptionHandler
    public String handleException(Exception exp) {
        return new String("This Message will appear intstead of messag" + exp.getMessage() + exp.getClass());
    }

}