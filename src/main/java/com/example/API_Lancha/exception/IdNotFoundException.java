package com.example.API_Lancha.exception;

public class IdNotFoundException extends  RuntimeException{
    public IdNotFoundException (String error){
        super(error);
    }
}
