package com.devconnect.microservices.profileservice.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class ProfileAdvise {

    @ResponseBody
    @ExceptionHandler(ProfileException.class)
    public final ResponseEntity<Object> ProfileNotFoundResponseResponseEntity(ProfileException ex){
        ProfileNotFoundResponse response = new ProfileNotFoundResponse(ex.getMessage());
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

}
