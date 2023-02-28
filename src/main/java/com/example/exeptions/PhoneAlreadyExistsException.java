package com.example.exeptions;

public class PhoneAlreadyExistsException extends RuntimeException{
    public PhoneAlreadyExistsException(String message) {
        super(message);
    }
}
