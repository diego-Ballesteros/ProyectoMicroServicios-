package edu.unimagdalena.demo.persistence.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "Messages")
@Getter
@Setter
@NoArgsConstructor
public class MessageEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_message", unique = true)
    private Long id;

    private String creator;

    private String addressee;

    @Column(columnDefinition = "DATETIME", nullable = false)
    private LocalDateTime create_at;

    private String content;

    // ----- FK
    @Column(name = "user_id")
    private Long idUser;

    // ------ RELATTION

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id_user", insertable = false, updatable = false)
    @JsonIgnore
    private UserEntity user;
}
