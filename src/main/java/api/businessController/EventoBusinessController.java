package api.businessController;

import api.daos.DaoFactory;
import api.dtos.EventoDto;
import api.entities.Evento;
import api.entities.Empresa;
import api.exceptions.NotFoundException;

public class EventoBusinessController {

    public String create(EventoDto eventoDto) {
        Empresa empresa = DaoFactory.getFactory().getEmpresaDao().read(eventoDto.getEmpresaId()).orElseThrow(
                () -> new NotFoundException("Empresa (" + eventoDto.getEmpresaId() + ")"));
        Evento evento = new Evento(eventoDto.getNombre(), eventoDto.getDescripcion(), eventoDto.isEstado(), eventoDto.getTipoEvento(), empresa);
        DaoFactory.getFactory().eventoDao().save(evento);
        return evento.getId();
    }

}
