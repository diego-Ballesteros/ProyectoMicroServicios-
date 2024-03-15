package edu.unimagdalena.demo.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Users")
@Getter
@Setter
@NoArgsConstructor

public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user", nullable = false, unique = true)
    private Long id;

    @Column(length = 100)
    private String userName;

    private String name;

    private String lastName;

    @Column(unique = true)
    private String email;

    private Integer age;

    @Column(nullable = false, length = 100)
    private String password;

    @Column(nullable = false, length = 100)
    private String repPassword;

    @Column( nullable = false, columnDefinition = "TINYINT")
    private Boolean enable;

    private String photo;

    private String rol;

    @Column(columnDefinition = "DATETIME", nullable = false)
    private LocalDateTime create_at;

    @ManyToMany
    @JoinTable( name = "User_games",
                joinColumns = @JoinColumn(name = "User_id"),
                inverseJoinColumns = @JoinColumn (name = "game_id"))
    private List<GameEntity> games ;

}
