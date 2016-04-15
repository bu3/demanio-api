package com.sigeosrl.demanio

import spock.lang.Specification


class RegioneServiceSpec extends Specification {

    def "return a list of Regioni"() {
        given:
        RegioneService service = new RegioneService(repository: Mock(RegioneRepository))

        when:
        def regioni = service.findRegioni()

        then:
        1 * service.repository.findAll() >> {
            [new Regione(id: 1L, name: 'Lazio'), new Regione()]
        }

        regioni.size() == 2
        regioni[0].id == 1L
        regioni[0].name == 'Lazio'
    }
}
