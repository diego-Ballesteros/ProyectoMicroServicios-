package edu.unimagdalena.demo.service.impl;

import edu.unimagdalena.demo.persistence.entity.UserEntity;
import edu.unimagdalena.demo.persistence.repository.UserRepository;
import edu.unimagdalena.demo.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<UserEntity> getAll(){
        return this.userRepository.findAll();
   }
    @Override
    public List<UserEntity> findAllByNameAndLastName(String name, String lastName) {
        return this.userRepository.findAllByNameAndLastName(name, lastName);
    }

    @Override
    public List<UserEntity> findByUserNameOrEmail(String userName, String email) {
        return this.userRepository.findByUserNameOrEmail(userName, email);
    }
}
