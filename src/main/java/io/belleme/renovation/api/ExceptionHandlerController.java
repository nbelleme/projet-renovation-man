package io.belleme.renovation.api;

import io.belleme.renovation.model.exception.EmailAlreadyAnsweredException;
import io.belleme.renovation.model.exception.IncorrectNumberOfResponseException;
import io.belleme.renovation.model.exception.QuestionAlreadyInQuestionnaireException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ExceptionHandlerController {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({
            QuestionAlreadyInQuestionnaireException.class,
            IncorrectNumberOfResponseException.class,
            EmailAlreadyAnsweredException.class
    })
    public ResponseEntity<String> handleBadRequest(RuntimeException e) {
        return ResponseEntity.badRequest()
                             .body(e.getMessage());
    }
}
