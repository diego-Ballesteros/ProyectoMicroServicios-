package edu.unimagdalena.demo.persistence.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;

@Entity
@Table(name = "Suggestions")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SuggestionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_suggestion", unique = true)
    private Long id;

    @Column(length = 500, nullable = false)
    private String description;

    private Timestamp create_at;

    // ----- FK
    @Column(name = "user_id")
    private Long idUser;

    // ------ RELATTION

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id_user", insertable = false, updatable = false)
    @JsonIgnore
    private UserEntity userEntity;
}
