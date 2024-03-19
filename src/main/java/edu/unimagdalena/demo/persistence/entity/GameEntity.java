package edu.unimagdalena.demo.persistence.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Games")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GameEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_game", unique = true)
    private Long id;

    @Column(length = 100, nullable = false)
    private String Creator;

    @Column(length = 150, nullable = false)
    private String sport;

    @Column(length = 150)
    private String city;

    private String province;

    private LocalDateTime date;

    private LocalDateTime startHour;

    private LocalDateTime endHour;

    private Integer beginner;

    private Integer alternate;

    private String comment;

    @ManyToMany(mappedBy = "games")
    private List<UserEntity> userEntities ;

}
