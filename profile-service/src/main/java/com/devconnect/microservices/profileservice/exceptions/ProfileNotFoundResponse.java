package com.devconnect.microservices.profileservice.exceptions;

public class ProfileNotFoundResponse {
    private String profileNotFound;

    public ProfileNotFoundResponse(String profileNotFound) {
        this.profileNotFound = profileNotFound;
    }
}
