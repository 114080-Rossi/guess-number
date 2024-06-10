package ar.edu.utn.frc.tup.ic.iii.services.impl;

import ar.edu.utn.frc.tup.ic.iii.dtos.MatchDto;
import ar.edu.utn.frc.tup.ic.iii.entities.MatchEntity;
import ar.edu.utn.frc.tup.ic.iii.entities.UserEntity;
import ar.edu.utn.frc.tup.ic.iii.models.*;
import ar.edu.utn.frc.tup.ic.iii.repositories.MatchRepository;
import ar.edu.utn.frc.tup.ic.iii.services.MatchService;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Random;

@Service
public class MatchServiceImpl implements MatchService {
    @Autowired
    private MatchRepository matchRepository;

    @Autowired
    private ModelMapper modelMapper;

    private final Random random = new Random();

    @Override
    public Match createMatch(User user, MatchDifficulti matchDifficulti) {
        MatchEntity matchEntity = new MatchEntity();
        matchEntity.setUserEntity(modelMapper.map(user, UserEntity.class));
        matchEntity.setMatchDifficulti(matchDifficulti);
        switch (matchDifficulti){
            case HARD -> matchEntity.setRemainingTries(5);
            case MEDIUM -> matchEntity.setRemainingTries(8);
            case EASY -> matchEntity.setRemainingTries(10);
        }
        matchEntity.setNumberToGuess(random.nextInt(101));
        matchEntity.setStatus(MatchStatus.PLAYING);
        matchEntity.setCreateAt(LocalDateTime.now());
        matchEntity.setUpdateAt(LocalDateTime.now());
        MatchEntity matchEntitySaved = matchRepository.save(matchEntity);
        return modelMapper.map(matchEntitySaved, Match.class);
    }

    @Override
    public Match getMatchById(Long matchId) {
        Optional<MatchEntity> matchEntityOptional =  matchRepository.findById(matchId);
        if (matchEntityOptional.isEmpty()){
            throw new EntityNotFoundException();
        } else {
            return modelMapper.map(matchEntityOptional.get(), Match.class);
        }
    }

    @Override
    public RoundMatch playMatch(Match match, Integer number) {
        RoundMatch roundMatch = new RoundMatch();
        roundMatch.setMatch(match);
        if (match.getStatus().equals(MatchStatus.FINISH)){
            //TODO: ERROR
            //Un error que diga que la partida ya esta terminada y no pueda continuar
            return null;
        }
        if (match.getNumberToGuess().equals(number)){
            //TODO: CALCULAR SCORE
            //TODO: DAR RESPUESTA
            //DEVOLVEMOS EL MATCH QUE GANO
            match.setStatus(MatchStatus.FINISH);
            roundMatch.setRespuesta("GANO");
        }else {
            match.setRemainingTries(match.getRemainingTries() -1 );
            if (match.getNumberToGuess().equals(0)){
                match.setStatus(MatchStatus.FINISH);
                roundMatch.setRespuesta("PERDIO");
            }else {
                if (number > match.getNumberToGuess()){
                    //TODO: Responder MENOR
                    roundMatch.setRespuesta("MENOR");
                }else {
                    //TODO: Responder MAYOR
                    roundMatch.setRespuesta("MAYOR");
                }
            }
        }
        UserEntity userEntity = modelMapper.map(match.getUser(), UserEntity.class);
        MatchEntity matchEntity = modelMapper.map(match, MatchEntity.class);
        matchEntity.setUserEntity(userEntity);
        matchEntity.setUpdateAt(LocalDateTime.now());
        matchRepository.save(matchEntity);
        return roundMatch;
    }
}
