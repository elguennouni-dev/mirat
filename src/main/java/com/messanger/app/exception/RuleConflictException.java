package com.messanger.app.exception;

public class RuleConflictException extends RuntimeException {

    public RuleConflictException() {
        super("Rule Conflict!");
    }

    public RuleConflictException(String message) {
        super(message);
    }
}
