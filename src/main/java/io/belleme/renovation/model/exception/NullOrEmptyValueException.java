package io.belleme.renovation.model.exception;

public class NullOrEmptyValueException extends RuntimeException {

    public NullOrEmptyValueException() {
        super("La valeur ne peut pas être nulle ou vide.");
    }
}
