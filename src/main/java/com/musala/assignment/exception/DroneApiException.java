package com.musala.assignment.exception;

import org.springframework.http.HttpStatus;

public class DroneApiException extends RuntimeException{

    private HttpStatus status;
    private String message;

    public DroneApiException(HttpStatus status, String message) {
        this.status = status;
        this.message = message;
    }

    public DroneApiException(String message, HttpStatus status, String message1) {
        super(message);
        this.status = status;
        this.message = message1;
    }

    public HttpStatus getStatus() {
        return status;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
