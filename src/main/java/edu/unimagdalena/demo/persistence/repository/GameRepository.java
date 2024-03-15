package edu.unimagdalena.demo.persistence.repository;

import edu.unimagdalena.demo.persistence.entity.GameEntity;
import org.springframework.data.repository.ListCrudRepository;

public interface GameRepository extends ListCrudRepository<GameEntity, Long> {

}
