package com.switchfully.order.exceptions;

public class WrongPasswordException extends RuntimeException {
    public WrongPasswordException() {
    }

    public WrongPasswordException(String message) {
        super(message);
    }
}
