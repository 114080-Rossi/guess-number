package ar.edu.utn.frc.tup.ic.iii.services.impl;

import ar.edu.utn.frc.tup.ic.iii.models.Dummy;
import ar.edu.utn.frc.tup.ic.iii.repositories.DummyRepository;
import ar.edu.utn.frc.tup.ic.iii.services.DummyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service //Sea parte de aplication contect de spring
public class DummyServiceImpl implements DummyService{ //Esto es una IMPLEMENTACION DE DummyService

    @Autowired //Cableamos con el repositorio
    private DummyRepository dummyRepository;


    @Override
    public Dummy getDummy(Long id) {
        return null;
    }

    @Override
    public List<Dummy> getDummyList() {
        return null;
    }

    @Override
    public Dummy createDummy(Dummy dummy) {
        return null;
    }

    @Override
    public Dummy updateDummy(Dummy dummy) {
        return null;
    }

    @Override
    public void deleteDummy(Dummy dummy) {

    }
}
