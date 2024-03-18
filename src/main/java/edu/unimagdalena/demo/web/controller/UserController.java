package edu.unimagdalena.demo.web.controller;

import edu.unimagdalena.demo.persistence.entity.UserEntity;
import edu.unimagdalena.demo.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/appmicro/user")
public class UserController {
    private final UserService userService;
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<UserEntity>> getAll(){
        List<UserEntity> users = this.userService.getAll();
        return ResponseEntity.ok(users);
    }
}
