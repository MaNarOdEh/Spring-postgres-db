package com.example.demo.security;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class TokenUtil {
    private final String CLAIMS_SUBJECT = "sub";
    private final String CLAIMS_CREATED = "created";
    @Value("${auth.expirtaion}")
    private Long TOKEN_VALIDATIY = 604800L; // 7 Days in seconds
    @Value("${auth.secret}")
    private String TOKEN_SECRET = "movieAPISecret";

    public String generateToken(UserDetails userDetils) {
        Map<String, Object> claims = new HashMap<>();
        claims.put(CLAIMS_SUBJECT, userDetils.getUsername());
        claims.put(CLAIMS_CREATED, new Date());
        System.out.println(Jwts.builder().setClaims(claims).setExpiration(generateExperiation())
                .signWith(SignatureAlgorithm.HS512, TOKEN_SECRET).compact());
        return Jwts.builder().setClaims(claims).setExpiration(generateExperiation())
                .signWith(SignatureAlgorithm.HS512, TOKEN_SECRET).compact();

    }

    private Date generateExperiation() {
        return new Date(System.currentTimeMillis() + TOKEN_VALIDATIY * 1000);// convert to millisecond
    }
}