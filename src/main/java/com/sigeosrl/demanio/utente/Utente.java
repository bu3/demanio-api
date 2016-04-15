package com.sigeosrl.demanio.utente;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.sigeosrl.demanio.regioni.Regione;

import javax.persistence.*;
import java.util.List;

@Entity
public class Utente {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private String name;

    private String surname;

    @ManyToMany(mappedBy="utenti" )
    @JsonBackReference
    private List<Regione> regioni;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public List<Regione> getRegioni() {
        return regioni;
    }

    public void setRegioni(List<Regione> regioni) {
        this.regioni = regioni;
    }
}
