package io.belleme.renovation.model;

import io.belleme.renovation.model.exception.IncorrectEmailFormatException;
import io.belleme.renovation.model.exception.NullOrEmptyValueException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

class EmailTest {

    @Test
    void validateEmptyEmail() {
        Email email = new Email("");
        assertThrows(NullOrEmptyValueException.class, email::validate);
    }

    @Test
    void validateInvalidEmail() {


        Email email = new Email("an email");
        assertThrows(IncorrectEmailFormatException.class, email::validate);
    }

}