package ar.edu.utn.frc.tup.ic.iii.services;

import ar.edu.utn.frc.tup.ic.iii.models.Match;
import ar.edu.utn.frc.tup.ic.iii.models.MatchDifficulti;
import ar.edu.utn.frc.tup.ic.iii.models.RoundMatch;
import ar.edu.utn.frc.tup.ic.iii.models.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    User createUser(String userName, String email);

    Match createUserMatch(Long userId, MatchDifficulti matchDifficulty);

    RoundMatch playUserMatch(Long userId, Long matchId, Integer numberToPlay);

}
