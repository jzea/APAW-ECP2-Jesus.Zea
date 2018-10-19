package api.apiControllers;

import api.businessController.ComentarioBusinessController;
import api.dtos.ComentarioDto;
import api.exceptions.ArgumentNotValidException;

public class ComentarioApiController {

    public static final String COMENTARIOS = "/comentarios";

    public static final String ID_ID = "/{id}";

    private ComentarioBusinessController comentarioBusinessController = new ComentarioBusinessController();

    public String create(ComentarioDto comentarioDto) {
        this.validate(comentarioDto, "comentarioDto");
        this.validate(comentarioDto.getTitulo(), "ComentarioDto Titulo");
        this.validate(comentarioDto.getDescripcion(), "ComentarioDto Descripción");
        return this.comentarioBusinessController.create(comentarioDto);
    }

    public void update(String id, ComentarioDto comentarioDto) {
        this.validate(comentarioDto, "comentarioDto");
        this.validate(comentarioDto.getTitulo(), "ComentarioDto Titulo");
        this.validate(comentarioDto.getDescripcion(), "ComentarioDto Descripción");
        this.comentarioBusinessController.update(id, comentarioDto);
    }
    
    private void validate(Object property, String message) {
        if (property == null) {
            throw new ArgumentNotValidException(message + " is NULL");
        }
    }
}
