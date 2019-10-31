package io.belleme.renovation.service;


import io.belleme.renovation.model.Question;
import io.belleme.renovation.persistence.QuestionDao;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {

    private QuestionDao questionDao;

    public QuestionService(QuestionDao questionDao) {
        this.questionDao = questionDao;
    }

    public List<Question> findAll() {
        return questionDao.findAll();
    }

}
