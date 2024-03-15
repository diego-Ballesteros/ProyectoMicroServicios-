package edu.unimagdalena.demo.persistence.repository;

import edu.unimagdalena.demo.persistence.entity.UserEntity;
import org.springframework.data.repository.ListCrudRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends ListCrudRepository<UserEntity,Long> {

    List<UserEntity> findAllByNameAndLastName(String name, String lastName);
    List<UserEntity> findByUserNameOrEmail(String userName, String email);

    Optional<UserEntity> findById(Long id);

}
