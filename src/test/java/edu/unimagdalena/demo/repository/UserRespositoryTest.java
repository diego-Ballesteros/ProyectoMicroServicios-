package edu.unimagdalena.demo.repository;

import edu.unimagdalena.demo.AbstractIntegrationDBTest;
import edu.unimagdalena.demo.persistence.entity.UserEntity;
import edu.unimagdalena.demo.persistence.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

public class UserRespositoryTest extends AbstractIntegrationDBTest {

    UserRepository userRepository;
    @Autowired
    public UserRespositoryTest(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    private UserEntity initMock1User(String name, String lastName, String username, String password) {
        return UserEntity.builder()
                .name(name)
                .lastName(lastName)
                .userName(username)
                .password(password)
                .build();
    }

    private void initMock2Users(){
        UserEntity user = UserEntity.builder()
                .name("Diego")
                .lastName("Ballesteros")
                .userName("db")
                .password("123")
                .photo("https://www.google.com/imageExample")
                .rol("user")
                .create_at(LocalDateTime.now())
                .build();
        this.userRepository.save(user);

        UserEntity user2 = UserEntity.builder()
                .name("Andres")
                .lastName("Cediel")
                .userName("ac")
                .password("123")
                .photo("https://www.google.com/imageExample")
                .rol("user")
                .create_at(LocalDateTime.now())
                .build();
        this.userRepository.save(user2);
        this.userRepository.flush();
    }

    @BeforeEach
    void setUp(){
        this.userRepository.deleteAll();
    }

    @Test
    void givenAnUser_whenSave_thenUserwithId(){
        //given
        UserEntity user = initMock1User("Diego", "Ballesteros", "db", "123");

        //when
        UserEntity userSaved = this.userRepository.save(user);
        //then
        assertThat(userSaved.getId()).isNotNull();
    }

    @Test
    @DisplayName("dado un conjunto de usuarios al buscarlo todos obtenemos la lista de los usuarios en la base de datos")
    void shouldGetAllUsers(){
        //Given
        initMock2Users();
        //when
        List<UserEntity> users = this.userRepository.findAll();
        //then
        assertThat(users).hasSize(2);
    }

    @Test
    void givenUsers_whenFindByNameAnsLastName_thenGetUserList(){
        //give
        initMock2Users();
        // when
        List<UserEntity> usersFound = this.userRepository.findAllByNameAndLastName("Diego", "Ballesteros");
        //then
        assertThat(usersFound).isNotEmpty();
        assertThat(usersFound).first().hasFieldOrPropertyWithValue("name", "Diego");

    }

}
