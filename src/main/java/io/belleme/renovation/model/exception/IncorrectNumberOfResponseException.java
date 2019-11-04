package io.belleme.renovation.model.exception;

public class IncorrectNumberOfResponseException extends RuntimeException {

    public IncorrectNumberOfResponseException() {
        super("Le nombre de réponse fourni est incorrect.");
    }
}
