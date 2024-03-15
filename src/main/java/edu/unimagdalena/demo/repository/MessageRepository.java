package edu.unimagdalena.demo.repository;

import edu.unimagdalena.demo.persistence.entity.Message;
import org.springframework.data.repository.ListCrudRepository;

public interface MessageRepository extends ListCrudRepository<Long, Message> {

}
