package api;

import api.apiControllers.EventoApiController;
import api.apiControllers.EmpresaApiController;
import api.daos.DaoFactory;
import api.daos.memory.DaoMemoryFactory;
import api.dtos.EventoDto;
import api.dtos.EmpresaDto;
import api.entities.TipoEvento;
import http.Client;
import http.HttpException;
import http.HttpRequest;
import http.HttpStatus;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class EventoIT {

    @BeforeAll
    static void before() {
        DaoFactory.setFactory(new DaoMemoryFactory());
    }

    private String createEmpresa() {
        HttpRequest request = HttpRequest.builder().path(EmpresaApiController.EMPRESAS).body(new EmpresaDto("Dia", "Dia S.A.C")).post();
        return (String) new Client().submit(request).getBody();
    }

    @Test
    void createEvento() {
        String empresaId = this.createEmpresa();
        HttpRequest request = HttpRequest.builder().path(EventoApiController.EVENTOS)
                .body(new EventoDto("Campeonato de futbol","Evento para socializar",true, TipoEvento.DEPORTIVO, empresaId)).post();
        new Client().submit(request);
    }
    @Test
    void createEventoEmpresaIdNotFound() {
        HttpRequest request = HttpRequest.builder().path(EventoApiController.EVENTOS)
                .body(new EventoDto("Evento one","Description one",true, TipoEvento.CULTURAL, "asdasd")).post();
        HttpException exception = assertThrows(HttpException.class, () -> new Client().submit(request));
        assertEquals(HttpStatus.NOT_FOUND, exception.getHttpStatus());
    }

    @Test
    void createEventoWithoutTipoEvento() {
        HttpRequest request = HttpRequest.builder().path(EventoApiController.EVENTOS)
                .body(new EventoDto("Evento one","Description one", true, null, "h3rFdEsw")).post();
        HttpException exception = assertThrows(HttpException.class, () -> new Client().submit(request));
        assertEquals(HttpStatus.BAD_REQUEST, exception.getHttpStatus());
    }
}
