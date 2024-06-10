package ar.edu.utn.frc.tup.ic.iii.entities;

import ar.edu.utn.frc.tup.ic.iii.models.MatchDifficulti;
import ar.edu.utn.frc.tup.ic.iii.models.MatchStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.core.SpringVersion;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "matches")
public class MatchEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @JoinColumn(name = "user_id")
    @ManyToOne
    private UserEntity userEntity;

    @Enumerated(EnumType.STRING)
    private MatchDifficulti matchDifficulti;

    private Integer numberToGuess; //Nro adivinar

    private Integer remainingTries; //Cantidad de intento

    @Enumerated(EnumType.STRING)
    private MatchStatus status;

    @Column
    private LocalDateTime createAt;

    @Column
    private LocalDateTime updateAt;
}
