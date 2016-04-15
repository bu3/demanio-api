package com.sigeosrl.demanio.regioni;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
public class RegioneController {

    @Autowired
    private RegioneService service;

    @RequestMapping(value = "regioni", method = GET)
    public List<Regione> findRegioni(){
        return service.findRegioni();
    }
}
