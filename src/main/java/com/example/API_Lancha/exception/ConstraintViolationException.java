package com.example.API_Lancha.exception;

public class ConstraintViolationException extends RuntimeException{
    public ConstraintViolationException(String error){
        super(error);
    }
}
