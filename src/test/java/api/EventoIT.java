package api;

import api.apiControllers.EventoApiController;
import api.apiControllers.EmpresaApiController;
import api.daos.DaoFactory;
import api.daos.memory.DaoMemoryFactory;
import api.dtos.EventoDto;
import api.dtos.EmpresaDto;
import api.entities.TipoEvento;
import http.Client;
import http.HttpRequest;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


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

}
