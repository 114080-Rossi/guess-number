package ar.edu.utn.frc.tup.ic.iii.services;

import ar.edu.utn.frc.tup.ic.iii.models.Match;
import ar.edu.utn.frc.tup.ic.iii.models.MatchDifficulti;
import ar.edu.utn.frc.tup.ic.iii.models.RoundMatch;
import ar.edu.utn.frc.tup.ic.iii.models.User;
import org.springframework.stereotype.Service;

@Service
public interface MatchService {
    Match createMatch(User user, MatchDifficulti matchDifficulti);

    Match getMatchById(Long matchId);


    RoundMatch playMatch(Match match, Integer number);
}
