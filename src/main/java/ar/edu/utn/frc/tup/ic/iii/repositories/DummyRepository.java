package ar.edu.utn.frc.tup.ic.iii.repositories;

import ar.edu.utn.frc.tup.ic.iii.entities.DummyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DummyRepository  extends JpaRepository<DummyEntity, Long> { //NUESTRA INTERFACE TIENE TODOS LOS METODOS QUE EXTIENDE DE JpaRepository
}
