package com.messanger.app.exception;

public class InvalidWasiyaException extends RuntimeException {

    public InvalidWasiyaException() {
        super("Invalid Wasiya!");
    }

    public InvalidWasiyaException(String message) {
        super(message);
    }
}
