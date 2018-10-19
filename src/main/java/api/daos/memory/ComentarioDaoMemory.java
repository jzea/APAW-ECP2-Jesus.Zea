package api.daos.memory;

import api.daos.ComentarioDao;
import api.entities.Comentario;

import java.util.HashMap;

public class ComentarioDaoMemory extends GenericDaoMemory<Comentario> implements ComentarioDao {

    public ComentarioDaoMemory() {
        super(new HashMap<>());
    }

    @Override
    public String getId(Comentario comentario) {
        return comentario.getId();
    }

    @Override
    public void setId(Comentario comentario, String id) {
        comentario.setId(id);
    }
}
