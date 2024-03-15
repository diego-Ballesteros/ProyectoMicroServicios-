package edu.unimagdalena.demo.service;

import edu.unimagdalena.demo.persistence.entity.UserEntity;

import java.util.List;

public interface UserService {

    List<UserEntity> findAllByNameAndLastName(String name, String lastName);
    List<UserEntity> findByUserNameOrEmail(String userName, String email);
    List<UserEntity> getAll();
}
