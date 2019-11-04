package io.belleme.renovation.model.exception;

public class EmailAlreadyAnsweredException extends RuntimeException {

    public EmailAlreadyAnsweredException() {
        super("L'email a déjà répondu au questionnaire.");
    }
}
