package com.sigeosrl.demanio.regioni;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.sigeosrl.demanio.utente.Utente;

import javax.persistence.*;
import java.util.List;

@Entity
public class Regione {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @Column
    private String name;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name="REGIONE_UTENTE",
            joinColumns=@JoinColumn(name="REGIONE_ID", referencedColumnName="ID"),
            inverseJoinColumns=@JoinColumn(name="UTENTE_ID", referencedColumnName="ID"))
    @JsonManagedReference
    private List<Utente> utenti;

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

    public List<Utente> getUtenti() {
        return utenti;
    }

    public void setUtenti(List<Utente> utenti) {
        this.utenti = utenti;
    }
}
