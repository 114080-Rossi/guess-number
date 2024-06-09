package ar.edu.utn.frc.tup.ic.iii.services;

import ar.edu.utn.frc.tup.ic.iii.models.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    User createUser(String userName, String email);
}
