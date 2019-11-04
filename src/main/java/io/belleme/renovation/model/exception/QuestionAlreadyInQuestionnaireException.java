package io.belleme.renovation.model.exception;

public class QuestionAlreadyInQuestionnaireException extends RuntimeException {

    public QuestionAlreadyInQuestionnaireException() {
        super("Le questionnaire comporte déjà une réponse pour la question");
    }
}
