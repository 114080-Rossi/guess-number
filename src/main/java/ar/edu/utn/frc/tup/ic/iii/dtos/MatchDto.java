package ar.edu.utn.frc.tup.ic.iii.dtos;

import ar.edu.utn.frc.tup.ic.iii.models.MatchDifficulti;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MatchDto {

    private Long id;

    private MatchDifficulti difficulty;

    private Integer remainingTries;

}
