package io.belleme.renovation.persistence;

import io.belleme.renovation.model.Reponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReponseDao extends JpaRepository<Reponse, Long> {
}
