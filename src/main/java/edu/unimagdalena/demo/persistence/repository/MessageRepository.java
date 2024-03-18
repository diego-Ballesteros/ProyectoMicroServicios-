package edu.unimagdalena.demo.persistence.repository;

import edu.unimagdalena.demo.persistence.entity.MessageEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.ListCrudRepository;

public interface MessageRepository extends JpaRepository<MessageEntity, Long> {

}
