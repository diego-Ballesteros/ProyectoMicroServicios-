package edu.unimagdalena.demo.repository;

import edu.unimagdalena.demo.AbstractIntegrationDBTest;
import edu.unimagdalena.demo.persistence.entity.SuggestionEntity;
import edu.unimagdalena.demo.persistence.repository.SuggestionRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

public class SuggestionRepositoryTest extends AbstractIntegrationDBTest {

    SuggestionRepository suggestionRepository;
    @Autowired
    public SuggestionRepositoryTest(SuggestionRepository suggestionRepository) {
        this.suggestionRepository = suggestionRepository;
    }

    private SuggestionEntity initMockSuggestion(String description){
        return SuggestionEntity.builder()
                .description(description)
                .create_at(Timestamp.valueOf(LocalDateTime.now()))
                .build();
    }
    @BeforeEach
    void setUp(){
        this.suggestionRepository.deleteAll();
    }

    @Test
    void givenASuggestion_whenSave_thenSuggestionWithId(){
        //Given
        SuggestionEntity suggestion = initMockSuggestion("descripcion sugerencia test");
        //When
        SuggestionEntity suggestionSaved = this.suggestionRepository.save(suggestion);
        //Than
        assertThat(suggestionSaved).isNotNull();
    }

}
