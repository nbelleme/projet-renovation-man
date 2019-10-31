package io.belleme.renovation.model;

import io.belleme.renovation.model.exception.IncorrectNumberOfResponseException;
import io.belleme.renovation.model.exception.NullEmailException;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertThrows;

class QuestionnaireTest {

    @Test
    void validateNotEnoughResponse() {
        Questionnaire questionnaire = Questionnaire.builder()
                                                   .email(new Email("ok@gmail.com"))
                                                   .reponses(new ArrayList<>())
                                                   .build();
        assertThrows(IncorrectNumberOfResponseException.class, questionnaire::validate);
    }

    @Test
    void validateNullEmail() {
        Questionnaire questionnaire = Questionnaire.builder()
                                                   .build();
        assertThrows(NullEmailException.class, questionnaire::validate);
    }


}