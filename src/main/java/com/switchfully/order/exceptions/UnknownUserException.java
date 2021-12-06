package com.switchfully.order.exceptions;

public class UnknownUserException extends RuntimeException{
    public UnknownUserException() {
    }
    public UnknownUserException(String message) {
        super(message);
    }
}
