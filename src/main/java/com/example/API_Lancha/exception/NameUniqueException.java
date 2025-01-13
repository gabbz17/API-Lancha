package com.example.API_Lancha.exception;

public class NameUniqueException extends RuntimeException{
    public NameUniqueException(String error){
        super(error);
    }
}
