package ar.edu.utn.frc.tup.ic.iii.services.impl;

import ar.edu.utn.frc.tup.ic.iii.entities.UserEntity;
import ar.edu.utn.frc.tup.ic.iii.models.User;
import ar.edu.utn.frc.tup.ic.iii.repositories.UserRepository;
import ar.edu.utn.frc.tup.ic.iii.services.UserService;
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
}
