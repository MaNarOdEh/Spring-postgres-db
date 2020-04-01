package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SignInRequest {
    private String userName;
    private String password;

    public SignInRequest() {
    }

    public SignInRequest(@JsonProperty("userName") String name, @JsonProperty("password") String password) {
        this.userName = name;
        this.password = password;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return this.password;
    }

    /**
     * @return the userName
     */
    public String getUserName() {
        return this.userName;
    }
}