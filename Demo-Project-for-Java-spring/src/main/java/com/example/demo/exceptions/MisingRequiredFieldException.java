package com.example.demo.exceptions;

public class MisingRequiredFieldException extends RuntimeException {

    private String message;

    public MisingRequiredFieldException(String message) {
        setMessage(message);
    }

    @Override
    public String getMessage() {
        return this.getMessage();
    }

    /**
     * @param message the message to set
     */
    public void setMessage(String message) {
        this.message = message;
    }
}