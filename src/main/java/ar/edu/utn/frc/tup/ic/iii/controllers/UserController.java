package ar.edu.utn.frc.tup.ic.iii.controllers;

import ar.edu.utn.frc.tup.ic.iii.dtos.UserDto;

import ar.edu.utn.frc.tup.ic.iii.models.User;
import ar.edu.utn.frc.tup.ic.iii.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/guess-number/users")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private ModelMapper modelMapper;
    @PostMapping("")
    public ResponseEntity<UserDto> createDummy(@RequestBody UserDto userDto){ // recibimos el userDto
        User user = userService.createUser(userDto.getUserName(), userDto.getEmail());// llamo al servicio
        UserDto userDtoCreated = modelMapper.map(user, UserDto.class);// el servicio me va a devolver un valor
        return ResponseEntity.ok(userDtoCreated);//y le voy a mapear el response OK
    }
}
