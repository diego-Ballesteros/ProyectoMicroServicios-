package edu.unimagdalena.demo.persistence.repository;

import edu.unimagdalena.demo.persistence.entity.SuggestionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.ListCrudRepository;

public interface SuggestionRepository extends JpaRepository<SuggestionEntity, Long> {
}
