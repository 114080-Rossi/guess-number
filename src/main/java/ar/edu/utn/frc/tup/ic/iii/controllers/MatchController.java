package ar.edu.utn.frc.tup.ic.iii.controllers;

import ar.edu.utn.frc.tup.ic.iii.services.MatchService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/guess-number/matches")
public class MatchController {
    private MatchService matchService;
}

