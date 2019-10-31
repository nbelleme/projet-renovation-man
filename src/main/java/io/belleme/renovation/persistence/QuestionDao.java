package io.belleme.renovation.persistence;

import io.belleme.renovation.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionDao extends JpaRepository<Question, Long> {

}
