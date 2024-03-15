package edu.unimagdalena.demo.persistence.repository;

import edu.unimagdalena.demo.persistence.entity.MessageEntity;
import org.springframework.data.repository.ListCrudRepository;

public interface MessageRepository extends ListCrudRepository<MessageEntity, Long> {

}
