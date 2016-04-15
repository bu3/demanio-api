package com.sigeosrl.integration

import com.sigeosrl.Application
import com.sigeosrl.demanio.Regione
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.test.IntegrationTest
import org.springframework.boot.test.SpringApplicationConfiguration
import org.springframework.boot.test.SpringApplicationContextLoader
import org.springframework.boot.test.TestRestTemplate
import org.springframework.boot.test.WebIntegrationTest
import org.springframework.http.HttpStatus
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.web.WebAppConfiguration
import org.springframework.web.client.RestTemplate
import spock.lang.Specification

import static org.springframework.http.HttpStatus.OK

@ContextConfiguration(loader = SpringApplicationContextLoader.class, classes = Application.class)
@WebAppConfiguration
@IntegrationTest(['server.port=0'])
class RegioneIntegrationSpec extends Specification {

    @Value('${local.server.port}')
    int port

    RestTemplate restTemplate = new TestRestTemplate()

    String getBasePath() { "" }

    String serviceURI(String path = "") {
        "http://127.0.0.1:$port/${basePath}${path}"
    }

    def "should return a list of Regioni"() {

        when:
        def regioni = restTemplate.getForEntity(serviceURI('/regioni'), Regione[])

        then:
        regioni.statusCode == OK
        regioni.body.size() == 4
        regioni.body[0].id == 1L
        regioni.body[0].name == 'Lazio'
        regioni.body[1].id == 2L
        regioni.body[1].name == 'Piemonte'
        regioni.body[2].id == 3L
        regioni.body[2].name == 'Toscana'
        regioni.body[3].id == 4L
        regioni.body[3].name == 'Umbria'
    }
}



