package com.sigeosrl.demanio

import org.hamcrest.CoreMatchers
import org.hamcrest.Matchers
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import spock.lang.Specification

import static org.springframework.http.MediaType.APPLICATION_JSON
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status


class RegioneControllerSpec extends Specification {

    def "return a list of Regioni"() {
        given:
        RegioneController regioneController = new RegioneController(service: Mock(RegioneService))
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(regioneController).build()

        when:
        def response = mockMvc.perform(get("/regioni").accept(APPLICATION_JSON))

        then:
        1 * regioneController.service.findRegioni() >> {
            [new Regione(id: 1L, name: 'Lazio'), new Regione()]
        }

        response.andExpect(status().isOk())
                .andExpect(jsonPath('$', Matchers.hasSize(2)))
                .andExpect(jsonPath('$[0].id', CoreMatchers.is(1)))
                .andExpect(jsonPath('$[0].name', CoreMatchers.is('Lazio')))
    }
}
