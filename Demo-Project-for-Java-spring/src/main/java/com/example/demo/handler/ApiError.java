package com.example.demo.handler;

import lombok.Data;

@Data
public class ApiError {
    private String message;

    public ApiError() {
        this.message = "Error";
    }

    public ApiError(String message) {
        this.message = message;
    }

    /**
     * @return the message
     */
    public String getMessage() {
        return "Error :" + message;
    }

}