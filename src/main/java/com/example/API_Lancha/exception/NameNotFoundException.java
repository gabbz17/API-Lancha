package com.example.API_Lancha.exception;

public class NameNotFoundException extends RuntimeException{
    public NameNotFoundException(String error) {
        super(error);
    }
}
