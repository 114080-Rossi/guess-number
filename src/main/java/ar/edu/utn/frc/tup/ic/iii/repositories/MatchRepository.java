package ar.edu.utn.frc.tup.ic.iii.repositories;


import ar.edu.utn.frc.tup.ic.iii.entities.MatchEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MatchRepository extends JpaRepository<MatchEntity, Long> {
}
