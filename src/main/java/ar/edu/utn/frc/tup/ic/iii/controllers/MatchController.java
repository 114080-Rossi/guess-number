package ar.edu.utn.frc.tup.ic.iii.controllers;

import ar.edu.utn.frc.tup.ic.iii.services.MatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/guess-number/matches")
public class MatchController {

    @Autowired
    private MatchService matchService; //Aca definimos el bean a MatchServices

    //Tenemos que establecer nuestro servicio de POST

}

