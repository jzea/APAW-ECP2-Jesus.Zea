package api;

import api.apiControllers.ComentarioApiController;
import api.daos.DaoFactory;
import api.daos.memory.DaoMemoryFactory;
import api.dtos.ComentarioDto;
import http.Client;
import http.HttpException;
import http.HttpRequest;
import http.HttpStatus;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ComentarioIT {

    @BeforeAll
    static void before() {
        DaoFactory.setFactory(new DaoMemoryFactory());
    }

    private String createComentario() {
        HttpRequest request = HttpRequest.builder().path(ComentarioApiController.COMENTARIOS).body(new ComentarioDto("titulo 1", "descripción 1")).post();
        return (String) new Client().submit(request).getBody();
    }

    @Test
    void testCreateComentario() {
        this.createComentario();
    }

    @Test
    void testComentarioInvalidRequest() {
        HttpRequest request = HttpRequest.builder().path(ComentarioApiController.COMENTARIOS + "/invalid").body(null).post();
        HttpException exception = assertThrows(HttpException.class, () -> new Client().submit(request));
        assertEquals(HttpStatus.BAD_REQUEST, exception.getHttpStatus());
    }

    @Test
    void testCreateComentarioWithoutComentarioDto() {
        HttpRequest request = HttpRequest.builder().path(ComentarioApiController.COMENTARIOS).body(null).post();
        HttpException exception = assertThrows(HttpException.class, () -> new Client().submit(request));
        assertEquals(HttpStatus.BAD_REQUEST, exception.getHttpStatus());
    }

    @Test
    void testUpdateComentario() {
        String id = this.createComentario();
        HttpRequest request = HttpRequest.builder().path(ComentarioApiController.COMENTARIOS).path(ComentarioApiController.ID_ID)
                .expandPath(id).body(new ComentarioDto("Titulo 2", "Descripción 2")).put();
        new Client().submit(request);
    }

    @Test
    void testUpdateComentarioWithoutComentarioDto() {
        String id = this.createComentario();
        HttpRequest request = HttpRequest.builder().path(ComentarioApiController.COMENTARIOS).path(ComentarioApiController.ID_ID)
                .expandPath(id).body(null).put();
        HttpException exception = assertThrows(HttpException.class, () -> new Client().submit(request));
        assertEquals(HttpStatus.BAD_REQUEST, exception.getHttpStatus());
    }

    @Test
    void testUpdateComentarioNotFoundException() {
        HttpRequest request = HttpRequest.builder().path(ComentarioApiController.COMENTARIOS).path(ComentarioApiController.ID_ID)
                .expandPath("s5FdeGf54D").body(new ComentarioDto("Titulo 2", "Descripción 2")).put();
        HttpException exception = assertThrows(HttpException.class, () -> new Client().submit(request));
        assertEquals(HttpStatus.NOT_FOUND, exception.getHttpStatus());
    }
}
