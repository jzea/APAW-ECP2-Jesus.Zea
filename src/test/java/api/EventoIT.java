package api;

import api.apiControllers.EventoApiController;
import api.apiControllers.EmpresaApiController;
import api.daos.DaoFactory;
import api.daos.memory.DaoMemoryFactory;
import api.dtos.EventoDto;
import api.dtos.EmpresaDto;
import api.dtos.HorarioDto;
import api.entities.TipoEvento;
import http.Client;
import http.HttpException;
import http.HttpRequest;
import http.HttpStatus;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import api.dtos.EventoNombreDescripcionDto;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDateTime;

public class EventoIT {

    @BeforeAll
    static void before() {
        DaoFactory.setFactory(new DaoMemoryFactory());
    }

    private String createEmpresa() {
        HttpRequest request = HttpRequest.builder().path(EmpresaApiController.EMPRESAS).body(new EmpresaDto("Dia", "Dia S.A.C")).post();
        return (String) new Client().submit(request).getBody();
    }

    private String createEvento(String name, String descripcion) {
        String empresaId = this.createEmpresa();
        HttpRequest request = HttpRequest.builder().path(EventoApiController.EVENTOS)
                .body(new EventoDto(name, descripcion, true, TipoEvento.DEPORTIVO, empresaId)).post();
        return (String) new Client().submit(request).getBody();
    }

    @Test
    void testCreateEvento() {
        this.createEvento("Campeonato de futbol", "Evento para socializar");
    }

    @Test
    void testCreateEventoEmpresaIdNotFound() {
        HttpRequest request = HttpRequest.builder().path(EventoApiController.EVENTOS)
                .body(new EventoDto("Evento one", "Description one", true, TipoEvento.CULTURAL, "asdasd")).post();
        HttpException exception = assertThrows(HttpException.class, () -> new Client().submit(request));
        assertEquals(HttpStatus.NOT_FOUND, exception.getHttpStatus());
    }

    @Test
    void testCreateEventoWithoutTipoEvento() {
        HttpRequest request = HttpRequest.builder().path(EventoApiController.EVENTOS)
                .body(new EventoDto("Evento one", "Description one", true, null, "h3rFdEsw")).post();
        HttpException exception = assertThrows(HttpException.class, () -> new Client().submit(request));
        assertEquals(HttpStatus.BAD_REQUEST, exception.getHttpStatus());
    }

    @Test
    void testReadAll() {
        for (int i = 0; i < 5; i++) {
            this.createEvento("evento" + i, "evento descripción " + i);
        }
        HttpRequest request = HttpRequest.builder().path(EventoApiController.EVENTOS).get();
        List<EventoNombreDescripcionDto> eventos = (List<EventoNombreDescripcionDto>) new Client().submit(request).getBody();
        assertTrue(eventos.size() >= 5);
    }

    @Test
    void testDelete() {
        String id = this.createEvento("Campeonato de futbol", "Evento para socializar");
        HttpRequest request1 = HttpRequest.builder().path(EventoApiController.EVENTOS).get();
        int count = ((List<EventoNombreDescripcionDto>) new Client().submit(request1).getBody()).size();
        HttpRequest request2 = HttpRequest.builder().path(EventoApiController.EVENTOS).path(EmpresaApiController.ID_ID)
                .expandPath(id).delete();
        new Client().submit(request2);
        assertTrue(((List<EventoNombreDescripcionDto>) new Client().submit(request1).getBody()).size() < count);
    }

    @Test
    void testHorarioEvento() {
        String id = this.createEvento("Campeonato de futbol", "Evento para socializar");
        HttpRequest request = HttpRequest.builder().path(EventoApiController.EVENTOS).path(EmpresaApiController.ID_ID)
                .expandPath(id).path(EventoApiController.HORARIOS).body(new HorarioDto(LocalDateTime.of(2018, 10, 12, 14, 30), LocalDateTime.of(2018, 10, 12, 20, 30))).post();
        new Client().submit(request);
        new Client().submit(request);
    }

    @Test
    void testHorarioEventoEventoIdNotFound() {
        HttpRequest request = HttpRequest.builder().path(EventoApiController.EVENTOS).path(EmpresaApiController.ID_ID)
                .expandPath("h3rFdEsw").path(EventoApiController.HORARIOS).body(new HorarioDto(LocalDateTime.of(2018, 10, 12, 14, 30), LocalDateTime.of(2018, 10, 12, 20, 30))).post();
        HttpException exception = assertThrows(HttpException.class, () -> new Client().submit(request));
        assertEquals(HttpStatus.NOT_FOUND, exception.getHttpStatus());
    }

}
