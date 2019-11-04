package io.belleme.renovation.model.exception;

public class IncorrectEmailFormatException extends RuntimeException {
    public IncorrectEmailFormatException() {
        super("Le format de l'email est incorrect.");
    }
}
