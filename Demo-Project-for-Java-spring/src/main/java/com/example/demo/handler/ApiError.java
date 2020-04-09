package com.example.demo.handler;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

import lombok.Data;

@Data
public class ApiError {
    private String message;
    private String timestamp;
    private String debugMessage;
    private HttpStatus httpStatus;

    public ApiError() {
        this.timestamp = LocalDateTime.now() + "";
    }

    public ApiError(String message) {
        this();
        this.message = message;
    }

    public ApiError(String message, Throwable throwable) {
        this();
        this.message = message;
        this.debugMessage = throwable.getLocalizedMessage();
    }

    public ApiError(String message, HttpStatus httpStatus) {
        this();
        this.message = message;
        this.httpStatus = httpStatus;
    }

    /**
     * @return the message
     */
    public String getMessage() {
        return message;
    }

    /**
     * @return the httpStatus
     */
    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    /**
     * @param httpStatus the httpStatus to set
     */
    public void setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }

    /**
     * @return the timestamp
     */
    public String getTimestamp() {
        return timestamp;
    }

    /**
     * @param timestamp the timestamp to set
     */
    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

}