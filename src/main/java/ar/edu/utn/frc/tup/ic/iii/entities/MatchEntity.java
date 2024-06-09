package ar.edu.utn.frc.tup.ic.iii.entities;

import jakarta.persistence.*;

@Entity
public class MatchEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
}
