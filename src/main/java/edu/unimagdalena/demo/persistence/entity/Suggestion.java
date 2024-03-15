package edu.unimagdalena.demo.persistence.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

@Entity
@Table(name = "Suggestions")
@Getter
@Setter
@NoArgsConstructor
public class Suggestion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_suggestion", nullable = false, unique = true)
    private Long id;

    private String description;

    private Timestamp create_at;

    // ----- FK
    @Column(name = "user_id")
    private Long idUser;

    // ------ RELATTION

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id_user", insertable = false, updatable = false)
    @JsonIgnore
    private User user;
}
