package ar.edu.utn.frc.tup.ic.iii.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Match { //Caso de negocio de nuestro modelo

    private Long id;

    private User user;

    private MatchDifficulti difficulty;

    private Integer numberToGuess; //Nro adivinar

    private Integer remainingTries; //Cantidad de intento

    private MatchStatus status;
}
