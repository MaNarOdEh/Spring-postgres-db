package com.example.demo.model;

public class SignInRequest {
    private String userName;
    private String password;

    public SignInRequest() {
    }

    public SignInRequest(String name, String password) {
        this.userName = name;
        this.password = password;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @return the userName
     */
    public String getUserName() {
        return userName;
    }
}