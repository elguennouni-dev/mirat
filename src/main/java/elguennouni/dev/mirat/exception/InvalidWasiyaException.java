package elguennouni.dev.mirat.exception;

public class InvalidWasiyaException extends RuntimeException {

    public InvalidWasiyaException() {
        super("Invalid Wasiya!");
    }

    public InvalidWasiyaException(String message) {
        super(message);
    }
}
