package ar.edu.utn.frc.tup.ic.iii.services.impl;

import ar.edu.utn.frc.tup.ic.iii.repositories.MatchRepository;
import ar.edu.utn.frc.tup.ic.iii.services.MatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MatchServiceImpl implements MatchService {
    @Autowired
    private MatchRepository matchRepository;
}
