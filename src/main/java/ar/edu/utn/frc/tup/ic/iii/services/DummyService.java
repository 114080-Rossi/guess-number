package ar.edu.utn.frc.tup.ic.iii.services;

import ar.edu.utn.frc.tup.ic.iii.models.Dummy;
import org.springframework.stereotype.Service;

import java.util.Dictionary;
import java.util.List;

@Service //Esta clase es de tipo Service
public interface DummyService {

    //Lista de servicios que vamos a incluir
    //Establecer estos metodos
    Dummy getDummy(Long id);

    List<Dummy> getDummyList();

    Dummy createDummy(Dummy dummy);

    Dummy updateDummy(Dummy dummy);

    void deleteDummy(Dummy dummy);
}
