package com.example.demo.security;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtTokenUtil {
    private final String CLAIMS_SUBJECT = "sub";
    private final String CLAIMS_CREATED = "created";
    @Value("${auth.expirtaion}")
    private Long TOKEN_VALIDATIY = 604800L; // 7 Days in seconds
    @Value("${auth.secret}")
    private String TOKEN_SECRET = "movieAPISecret";

    /**
     * generateToken method
     * 
     * This method will generate user token from user information[claims] and
     * secret(Signature) , the token will identifies the user and will be used nect
     * in secure all the next response.
     * 
     * @param userDetils the userdetails that we want to genrate the token for it.
     * @return String compact token from [header,claims,secret]
     */
    public String generateToken(UserDetails userDetils) {
        Map<String, Object> claims = new HashMap<>();
        claims.put(CLAIMS_SUBJECT, userDetils.getUsername());
        claims.put(CLAIMS_CREATED, new Date());

        return Jwts.builder().setClaims(claims).setExpiration(generateExperiation())
                .signWith(SignatureAlgorithm.HS512, TOKEN_SECRET).compact();

    }

    /**
     * generateExpiration method
     * 
     * it will add 7 days to the current date.
     * 
     * @return expiration date
     */
    private Date generateExperiation() {
        return new Date(System.currentTimeMillis() + TOKEN_VALIDATIY * 1000);// convert to millisecond
    }

    /**
     * getUserNameFromToken method
     * 
     * This method will extract user details from user token and return user name
     * 
     * @param token it will accept user token and return userName from it.
     * @return String which represent user name or null in case if the token is
     *         wrong.
     */
    public String getUserNameFromToken(String token) {
        try {

            Claims claims = getClaims(token);
            return claims.getSubject();
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * isTokenValid method
     * 
     * This method will check if the token is valid by check the data expiration &
     * try to get user name from token and compare it with given user name.
     * 
     * @param token       represent user token
     * @param userDetails userDetails object which hold user name & user password
     * @return boolean true in case if the token is valid ,false otherwise
     */
    public boolean isTokenValid(String token, UserDetails userDetails) {
        String username = getUserNameFromToken(token);
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }

    /**
     * isTokenExpired
     * 
     * This methods will extract the expirtation data from the given token and
     * compare it with current date
     * 
     * @param token
     * @return return true when expirtation date is before current date,false
     *         otherwise
     */
    private boolean isTokenExpired(String token) {
        Date expiration = getClaims(token).getExpiration();
        return expiration.before(new Date());
    }

    /**
     * getClaims method
     * 
     * It will return the payload section [claims] from the token
     * 
     * @param token
     * @return claims which represent user info and other meta data
     */
    private Claims getClaims(String token) {
        Claims claims;
        try {
            claims = Jwts.parser().setSigningKey(TOKEN_SECRET).parseClaimsJws(token).getBody();
        } catch (Exception ex) {
            claims = null;
        }

        return claims;
    }
}