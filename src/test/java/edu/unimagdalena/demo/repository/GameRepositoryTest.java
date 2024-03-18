package edu.unimagdalena.demo.repository;

import edu.unimagdalena.demo.AbstractIntegrationDBTest;
import edu.unimagdalena.demo.persistence.entity.GameEntity;
import edu.unimagdalena.demo.persistence.repository.GameRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.Assertions.assertThat;

public class GameRepositoryTest extends AbstractIntegrationDBTest {

    GameRepository gameRepository;
    @Autowired
    public GameRepositoryTest(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    private GameEntity initMockGame(String creator, String sport, String city, String comment){
        return GameEntity.builder()
                .Creator(creator)
                .sport(sport)
                .city(city)
                .comment(comment)
                .build();
    }
    @BeforeEach
    void setUp(){
        this.gameRepository.deleteAll();
    }

    @Test
    void givenAnGame_whenSave_thenGamewithId(){
        //Given
        GameEntity game = initMockGame("Diego", "Futbol", "Colombia", "futbol colombiano tan malo ome");
        //When
        GameEntity gameSaved = this.gameRepository.save(game);
        //then
        assertThat(gameSaved.getId()).isNotNull();
        assertThat(gameSaved.getCreator()).isEqualTo("Diego");
        assertThat(gameSaved.getSport()).isEqualTo("Futbol");
    }
}
