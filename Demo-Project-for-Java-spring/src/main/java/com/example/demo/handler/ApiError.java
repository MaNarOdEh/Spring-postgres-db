package com.example.demo.handler;

import java.util.List;

import org.springframework.http.HttpStatus;

import lombok.Data;

@Data
public class ApiError {
    private String message;
    private HttpStatus status;
    private String debugMessage;
    private List<ApiSubError> subErrors;

    public ApiError() {
        this.message = "Error";
    }

    ApiError(HttpStatus status) {
        this();
        this.status = status;
    }

    ApiError(HttpStatus status, Throwable ex) {
        this();
        this.status = status;
        this.message = "Unexpected error";
        this.debugMessage = ex.getLocalizedMessage();
    }

    ApiError(HttpStatus status, String message, Throwable ex) {
        this();
        this.status = status;
        this.message = message;
        this.debugMessage = ex.getLocalizedMessage();
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