package io.belleme.renovation.service;

import io.belleme.renovation.model.Email;
import io.belleme.renovation.model.Questionnaire;
import io.belleme.renovation.model.Reponse;
import io.belleme.renovation.model.exception.EmailAlreadyAnsweredException;
import io.belleme.renovation.persistence.QuestionnaireDao;
import io.belleme.renovation.persistence.ReponseDao;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class QuestionnaireService {

    private QuestionnaireDao questionnaireDao;
    private ReponseDao reponseDao;

    public QuestionnaireService(QuestionnaireDao questionnaireDao, ReponseDao reponseDao) {
        this.questionnaireDao = questionnaireDao;
        this.reponseDao = reponseDao;
    }

    public Questionnaire save(Questionnaire questionnaire) {

        if (questionnaireDao.existsByEmail(questionnaire.getEmail())) {
            throw new EmailAlreadyAnsweredException();
        }

        List<Reponse> reponses = reponseDao.findAllById(questionnaire.getReponses()
                                                                     .stream()
                                                                     .map(Reponse::getId)
                                                                     .collect(Collectors.toList()));

        Questionnaire questionnaireToSave = Questionnaire.builder()
                                                         .email(questionnaire.getEmail())
                                                         .reponses(reponses)
                                                         .build();

        questionnaireToSave.validate();
        return questionnaireDao.save(questionnaireToSave);
    }

    public List<Questionnaire> getByEmail(String email) {
        return questionnaireDao.findAllByEmail(new Email(email));
    }

    public List<Questionnaire> getAll() {
        return questionnaireDao.findAll();

    }
}
