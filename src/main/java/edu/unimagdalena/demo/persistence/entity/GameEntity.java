package edu.unimagdalena.demo.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Games")
@Getter
@Setter
@NoArgsConstructor
public class GameEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_game", nullable = false, unique = true)
    private Long id;

    @Column(length = 100)
    private String Creator;

    private String sport;

    private String city;

    private String province;

    @Column(columnDefinition = "DATETIME", nullable = false)
    private LocalDateTime date;

    @Column(columnDefinition = "DATETIME", nullable = false)
    private LocalDateTime startHour;

    @Column(columnDefinition = "DATETIME", nullable = false)
    private LocalDateTime endHour;

    private Integer beginner;

    private Integer alternate;

    private String comment;

    @ManyToMany(mappedBy = "games")
    private List<UserEntity> userEntities ;

}
