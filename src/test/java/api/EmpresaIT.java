package api;

import api.apiControllers.EmpresaApiController;
import api.daos.DaoFactory;
import api.daos.memory.DaoMemoryFactory;
import http.Client;
import api.dtos.EmpresaDto;
import http.HttpException;
import http.HttpRequest;
import http.HttpStatus;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class EmpresaIT {

    @BeforeAll
    static void before() {
        DaoFactory.setFactory(new DaoMemoryFactory());
    }

    @Test
    void testCreateEmpresa() {
        this.createEmpresa();
    }

    private String createEmpresa() {
        HttpRequest request = HttpRequest.builder().path(EmpresaApiController.EMPRESAS).body(new EmpresaDto("Dia", "Dia S.A.C")).post();
        return (String) new Client().submit(request).getBody();
    }

    @Test
    void testEmpresaInvalidRequest() {
        HttpRequest request = HttpRequest.builder().path(EmpresaApiController.EMPRESAS + "/invalid").body(null).post();
        HttpException exception = assertThrows(HttpException.class, () -> new Client().submit(request));
        assertEquals(HttpStatus.BAD_REQUEST, exception.getHttpStatus());
    }

    @Test
    void testCreateEmpresaWithoutEmpresaDto() {
        HttpRequest request = HttpRequest.builder().path(EmpresaApiController.EMPRESAS).body(null).post();
        HttpException exception = assertThrows(HttpException.class, () -> new Client().submit(request));
        assertEquals(HttpStatus.BAD_REQUEST, exception.getHttpStatus());
    }

    @Test
    void testCreateEmpresaWithoutEmpresaDtoNombreAndRazonSocial() {
        HttpRequest request = HttpRequest.builder().path(EmpresaApiController.EMPRESAS).body(new EmpresaDto(null, null)).post();
        HttpException exception = assertThrows(HttpException.class, () -> new Client().submit(request));
        assertEquals(HttpStatus.BAD_REQUEST, exception.getHttpStatus());
    }

    @Test
    void testUpdateEmpresa() {
        String id = this.createEmpresa();
        HttpRequest request = HttpRequest.builder().path(EmpresaApiController.EMPRESAS).path(EmpresaApiController.ID_ID)
                .expandPath(id).body(new EmpresaDto("Dia business")).patch();
        new Client().submit(request);
    }

    @Test
    void testUpdateEmpresaWithoutEmpresaDto() {
        String id = this.createEmpresa();
        HttpRequest request = HttpRequest.builder().path(EmpresaApiController.EMPRESAS).path(EmpresaApiController.ID_ID)
                .expandPath(id).body(null).patch();
        HttpException exception = assertThrows(HttpException.class, () -> new Client().submit(request));
        assertEquals(HttpStatus.BAD_REQUEST, exception.getHttpStatus());
    }

    @Test
    void testUpdateEmpresaNotFoundException() {
        HttpRequest request = HttpRequest.builder().path(EmpresaApiController.EMPRESAS).path(EmpresaApiController.ID_ID)
                .expandPath("s5FdeGf54D").body(new EmpresaDto("dos")).patch();
        HttpException exception = assertThrows(HttpException.class, () -> new Client().submit(request));
        assertEquals(HttpStatus.NOT_FOUND, exception.getHttpStatus());
    }

}
