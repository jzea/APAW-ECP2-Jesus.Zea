package api.businessController;

import api.daos.DaoFactory;
import api.dtos.ComentarioDto;
import api.entities.Comentario;

public class ComentarioBusinessController {

    public String create(ComentarioDto comentarioDto) {
        Comentario comentario = new Comentario(comentarioDto.getTitulo(),comentarioDto.getDescripcion());
        DaoFactory.getFactory().getComentarioDao().save(comentario);
        return comentario.getId();
    }

}
