package com.example.demo.model;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table
public class User {

    @Id
    private UUID id;
    @NotBlank
    @Column(name = "userName")
    private String userName;
    @NotBlank
    @Column(name = "userPassword")
    private String userPassword;

    public User(@JsonProperty("userName") String userName, @JsonProperty("password") String password) {
        this.userName = userName;
        this.userPassword = password;
    }

    public User() {

    }

    /**
     * @return the id
     */
    public UUID getId() {
        return id;
    }

    /**
     * @return the userPassword
     */
    public String getUserPassword() {
        return userPassword;
    }

    /**
     * @return the userName
     */
    public String getUserName() {
        return userName;
    }

    /**
     * @param id the id to set
     */
    public void setId(UUID id) {
        this.id = id;
    }

    /**
     * @param userPassword the userPassword to set
     */
    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    /**
     * @param userName the userName to set
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }
}