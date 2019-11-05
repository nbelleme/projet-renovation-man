package io.belleme.renovation.service;

import io.belleme.renovation.model.Email;
import io.belleme.renovation.model.Question;
import io.belleme.renovation.model.Questionnaire;
import io.belleme.renovation.model.Reponse;
import io.belleme.renovation.model.exception.EmailAlreadyAnsweredException;
import io.belleme.renovation.persistence.QuestionnaireDaoTestImpl;
import io.belleme.renovation.persistence.ReponseDaoTestImpl;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class QuestionnaireServiceTest {

    private ReponseDaoTestImpl reponseDao;
    private QuestionnaireService questionnaireService;
    private QuestionnaireDaoTestImpl questionnaireDao;

    QuestionnaireServiceTest() {
        questionnaireDao = new QuestionnaireDaoTestImpl();
        reponseDao = new ReponseDaoTestImpl();
        questionnaireService = new QuestionnaireService(questionnaireDao, reponseDao);
    }


    @Test
    void save() {
        cleanDb();
        String email = "ok@gmail.com";

        List<Reponse> reponses = new ArrayList<>();

        reponses.add(Reponse.builder()
                            .id(1L)
                            .question(Question.builder()
                                              .id(1L)
                                              .build())
                            .build());
        reponses.add(Reponse.builder()
                            .id(2L)
                            .question(Question.builder()
                                              .id(2L)
                                              .build())
                            .build());
        reponses.add(Reponse.builder()
                            .id(3L)
                            .question(Question.builder()
                                              .id(3L)
                                              .build())
                            .build());

        reponses.forEach(reponse -> reponseDao.db.put(reponse.getId(), reponse));
        Questionnaire questionnaire = Questionnaire.builder()
                                                   .email(new Email(email))
                                                   .reponses(reponses)
                                                   .build();
        questionnaireService.save(questionnaire);
        assertEquals(questionnaireDao.db.get(email), questionnaire);

    }

    @Test
    void saveMailAlreadyInside(){
        cleanDb();

        String email = "ok@gmail.com";
        Questionnaire questionnaire = Questionnaire.builder()
                                                   .email(new Email(email))
                                                   .build();
        questionnaireDao.db.put(email, questionnaire);

        assertThrows(EmailAlreadyAnsweredException.class, () -> questionnaireService.save(questionnaire));

    }

    @Test
    void getByEmail() {
        cleanDb();
        String email = "ok@gmail.com";
        Questionnaire questionnaire = Questionnaire.builder()
                                                   .email(new Email(email))
                                                   .build();
        questionnaireDao.db.put(email, questionnaire);
        assertEquals(Collections.singletonList(questionnaire), questionnaireService.getByEmail(email));
    }

    @Test
    void getAll() {
        cleanDb();
        String email = "ok@gmail.com";
        questionnaireDao.db.put(email, Questionnaire.builder()
                                                    .email(new Email(email))
                                                    .build());
        String email1 = "ok1@gmail.com";
        questionnaireDao.db.put(email1, Questionnaire.builder()
                                                     .email(new Email(email1))
                                                     .build());
        assertEquals(new ArrayList<>(questionnaireDao.db.values()), questionnaireService.getAll());
    }

    @Test
    void getAllEmpty(){
        cleanDb();
        assertEquals(Collections.emptyList(), questionnaireService.getAll());
    }

    private void cleanDb() {
        questionnaireDao.clean();
        reponseDao.clean();
    }
}