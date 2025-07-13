package elguennouni.dev.mirat.exception;

public class RuleConflictException extends RuntimeException {

    public RuleConflictException() {
        super("Rule Conflict!");
    }

    public RuleConflictException(String message) {
        super(message);
    }
}
