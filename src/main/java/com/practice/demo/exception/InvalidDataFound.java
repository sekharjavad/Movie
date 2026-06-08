package com.practice.demo.exception;

public class InvalidDataFound extends RuntimeException{
    public InvalidDataFound(String message){
        super(message);
    }
}
