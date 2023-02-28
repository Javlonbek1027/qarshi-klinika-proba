package com.example.exeptions;

public class PasswordOrPhoneWrongException extends RuntimeException{
    public PasswordOrPhoneWrongException(String message) {
        super(message);
    }
}