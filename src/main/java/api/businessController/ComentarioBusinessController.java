package api.businessController;

import api.daos.DaoFactory;
import api.dtos.ComentarioDto;
import api.entities.Comentario;
import api.exceptions.NotFoundException;

public class ComentarioBusinessController {

    public String create(ComentarioDto comentarioDto) {
        Comentario comentario = new Comentario(comentarioDto.getTitulo(),comentarioDto.getDescripcion());
        DaoFactory.getFactory().getComentarioDao().save(comentario);
        return comentario.getId();
    }
    
    public void update(String id, ComentarioDto comentarioDto) {
        Comentario comentario = DaoFactory.getFactory().getComentarioDao().read(id).orElseThrow(() -> new NotFoundException("Comentario id: " + id));
        comentario.setTitulo(comentarioDto.getTitulo());
        comentario.setDescripcion(comentarioDto.getDescripcion());
        DaoFactory.getFactory().getComentarioDao().save(comentario);
    }
}
