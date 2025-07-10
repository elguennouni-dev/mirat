package com.messanger.app.exception;

public class InvalidHeirException extends RuntimeException {

    public InvalidHeirException() {
        super("Invalid Heir!");
    }

    public InvalidHeirException(String message) {
        super(message);
    }

}
