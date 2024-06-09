package ar.edu.utn.frc.tup.ic.iii.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Setter;

@Entity
@Data
@Setter
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "user_name", nullable = false)
    private String userName;

    //@UniqueConstraint()//NOS DICE QUE TENEMOS UNA CONSTRAINT UNICA PARA EL EMAIL
    @Column(name = "email", nullable = false)
    private String email;
}
