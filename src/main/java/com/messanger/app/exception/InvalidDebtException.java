package com.messanger.app.exception;

public class InvalidDebtException extends RuntimeException {

    public InvalidDebtException() {
        super("Invalid Debt!");
    }

    public InvalidDebtException(String message) {
        super(message);
    }
}
