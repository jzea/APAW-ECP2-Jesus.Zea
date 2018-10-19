package api.daos.memory;

import api.daos.EventoDao;
import api.entities.Evento;

import java.util.HashMap;

public class EventoDaoMemory extends GenericDaoMemory<Evento> implements EventoDao {

    public EventoDaoMemory() {
        super(new HashMap<>());
    }

    @Override
    public String getId(Evento evento) {
        return evento.getId();
    }

    @Override
    public void setId(Evento evento, String id) {
        evento.setId(id);
    }
}
