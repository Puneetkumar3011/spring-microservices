package com.devconnect.microservices.profileservice.exceptions;

public class ProfileException extends RuntimeException {
    public ProfileException(String message) {
        super(message);
    }
}
