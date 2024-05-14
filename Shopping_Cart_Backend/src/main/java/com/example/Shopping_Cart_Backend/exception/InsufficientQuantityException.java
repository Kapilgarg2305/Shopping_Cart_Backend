package com.example.Shopping_Cart_Backend.exception;

public class InsufficientQuantityException extends Exception{

    public InsufficientQuantityException(String message){

        super(message);
    }
}
