package ar.edu.utn.frc.tup.ic.iii.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Email;
import lombok.*;

//Con lombock nos ahorramos de escribir todos los getters y los setters ...
//@Data // NOS CREA TODOS LOS GETTERS Y SETTERS QUE NOS HACE FALTA
@Getter
@Setter
@NoArgsConstructor //GENERA UN CONSTRUCTOR SIN PARAMETRO
@AllArgsConstructor // GENERA UN CONSTRUCTOR CON TODOS LOS PARAMETROS

/*
DE ESTA MANERA ME AHORRE ESCRIBIR LOS GETTERS Y SETTERS Y LOS CONSTRUCTORES SIN PARAMETROS
 */
public class UserDto {
    private Long id;

    @JsonProperty("username") //Esto porque tiene que ir todoo en minuscula.... Leer documentacion
    private String userName;

    @Email //Esto nos verifica que lo que eviamos aca tine la forma de un email y tiene que seguir las especificaciones ...
    private String email;
}
