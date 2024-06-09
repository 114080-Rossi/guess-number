package ar.edu.utn.frc.tup.ic.iii.repositories;

import ar.edu.utn.frc.tup.ic.iii.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

    //Para hacer una consulta la podemos hacer por JPD

    //TODO Consulta SQL
    Optional<UserEntity> getByEmail(String email); //Esto ya esta por definido la consulta... pero esta es una forma rapida
    //El optional sirve porque puede no encontrarlo y esto lo captura y lo podemos utilizar...
}
