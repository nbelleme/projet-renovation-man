package io.belleme.renovation.persistence;

import io.belleme.renovation.model.Email;
import io.belleme.renovation.model.Questionnaire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionnaireDao extends JpaRepository<Questionnaire, Long> {
    List<Questionnaire> findAllByEmail(Email email);

    boolean existsByEmail(Email email);
}
