package io.belleme.renovation.model.exception;

public class NullEmailException extends RuntimeException {

    public NullEmailException() {
        super("L'adresse email ne peut pas être nulle.");
    }
}
