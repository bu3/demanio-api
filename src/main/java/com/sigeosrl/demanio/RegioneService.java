package com.sigeosrl.demanio;

import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RegioneService {

    @Autowired
    private RegioneRepository repository;

    public List<Regione> findRegioni(){
        return Lists.newArrayList(repository.findAll());
    }

}
