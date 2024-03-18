package edu.unimagdalena.demo.repository;

import edu.unimagdalena.demo.AbstractIntegrationDBTest;
import edu.unimagdalena.demo.persistence.entity.MessageEntity;
import edu.unimagdalena.demo.persistence.entity.UserEntity;
import edu.unimagdalena.demo.persistence.repository.MessageRepository;
import edu.unimagdalena.demo.persistence.repository.UserRepository;
import org.hibernate.exception.ConstraintViolationException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class MessageRepositoryTest extends AbstractIntegrationDBTest {
        MessageRepository messageRepository;
    @Autowired
    public MessageRepositoryTest(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    private MessageEntity initMock1Message(String creator, String addressee,String content, LocalDateTime create_at){
        return MessageEntity.builder()
                .creator(creator)
                .addressee(addressee)
                .content(content)
                .create_at(create_at)
                .build();
    }
    private void initMock2Message(){
        MessageEntity message = MessageEntity.builder()
                .creator("Diego")
                .addressee("Julian")
                .content("contenido del mensaje 1")
                .create_at(LocalDateTime.now())
                .build();
        this.messageRepository.save(message);

        MessageEntity message2 = MessageEntity.builder()
                .creator("Andres")
                .addressee("Pizarro")
                .content("contenido del mensaje 2")
                .create_at(LocalDateTime.now())
                .build();
        this.messageRepository.save(message2);
        this.messageRepository.flush();
    }

    @BeforeEach
    void setUp(){
        this.messageRepository.deleteAll();
    }

    @Test
    void givenAnMessage_whenSave_thenMessageWithId(){
        //given
        MessageEntity message = initMock1Message("Diego", "Pizarro", "contenido mensaje", LocalDateTime.now());
        //when
        MessageEntity messageSaved = this.messageRepository.save(message);
        //then
        assertThat(messageSaved.getId()).isNotNull();
        assertThat(messageSaved.getCreator()).isEqualTo("Diego");
        assertThat(messageSaved.getAddressee()).isEqualTo("Pizzarro");
    }

    @Test
    public void givenIncompleteMessage_whenSave_thenThrowException() {
        // GIVEN
        MessageEntity message = MessageEntity.builder()
                .content("Contenido de mensaje incompleto")
                // No se proporcionan creator, addressee ni create_at que son NotNull
                .build();

        // WHEN/THEN
        assertThatThrownBy(() -> messageRepository.save(message))
                .isInstanceOf(ConstraintViolationException.class);
        // Verificamos que se lance una ConstraintViolationException al intentar guardar el mensaje incompleto
    }

}