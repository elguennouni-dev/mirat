package com.messanger.app.exception;

public class InvalidWealthException extends RuntimeException {

    public InvalidWealthException() {
        super("Invalid Wealth!");
    }

    public InvalidWealthException(String message) {
        super(message);
    }
}
