package ar.edu.utn.frc.tup.ic.iii.controllers;

import ar.edu.utn.frc.tup.ic.iii.services.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/guess-number/users")
public class UserController {
    private UserService userService;
}
