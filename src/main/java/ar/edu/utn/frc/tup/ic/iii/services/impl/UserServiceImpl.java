package ar.edu.utn.frc.tup.ic.iii.services.impl;

import ar.edu.utn.frc.tup.ic.iii.entities.UserEntity;
import ar.edu.utn.frc.tup.ic.iii.models.Match;
import ar.edu.utn.frc.tup.ic.iii.models.MatchDifficulti;
import ar.edu.utn.frc.tup.ic.iii.models.RoundMatch;
import ar.edu.utn.frc.tup.ic.iii.models.User;
import ar.edu.utn.frc.tup.ic.iii.repositories.UserRepository;
import ar.edu.utn.frc.tup.ic.iii.services.MatchService;
import ar.edu.utn.frc.tup.ic.iii.services.UserService;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private MatchService matchService;

    @Override
    public User createUser(String userName, String email) {
        Optional<UserEntity> userEntityOptional = userRepository.getByEmail(email);
        if (userEntityOptional.isPresent()){
            //TODO: Enviar error al usuario.
            return null;
        }else {
            //TODO usuario no encontrado
            UserEntity userEntity = new UserEntity();
            userEntity.setUserName(userName);
            userEntity.setEmail(email);
            //Aca forzamos el guardado
            UserEntity userEntitySaved = userRepository.save(userEntity);

            //En caso de hacer un return nos hace falta el @ModelMapper
            return modelMapper.map(userEntitySaved, User.class);
        }
    }

    @Override
    public Match createUserMatch(Long userId, MatchDifficulti matchDifficulty) {
        Optional<UserEntity> userEntity = userRepository.findById(userId);
        if (userEntity.isEmpty()){
            throw new EntityNotFoundException();
        }else {
            User user = modelMapper.map(userEntity.get(), User.class);
            return matchService.createMatch(user, matchDifficulty);
        }
    }

    @Override
    public RoundMatch playUserMatch(Long userId, Long matchId, Integer numberToPlay) {
        Match match = matchService.getMatchById(matchId);
        if (!match.getUser().getId().equals(userId)){
            //Aca no jugamos
            //TODO: ERROR
            return null;
        }else {
            //aca jugamos
            return matchService.playMatch(match, numberToPlay);
        }
    }
}
