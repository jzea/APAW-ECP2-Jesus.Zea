package api.businessController;

import api.daos.DaoFactory;
import api.dtos.EventoDto;
import api.dtos.EventoNombreDescripcionDto;
import api.entities.Evento;
import api.entities.Empresa;
import api.exceptions.NotFoundException;
import api.dtos.HorarioDto;
import api.entities.Horario;

import java.util.List;
import java.util.stream.Collectors;

public class EventoBusinessController {

    public String create(EventoDto eventoDto) {
        Empresa empresa = DaoFactory.getFactory().getEmpresaDao().read(eventoDto.getEmpresaId()).orElseThrow(
                () -> new NotFoundException("Empresa (" + eventoDto.getEmpresaId() + ")"));
        Evento evento = new Evento(eventoDto.getNombre(), eventoDto.getDescripcion(), eventoDto.isEstado(), eventoDto.getTipoEvento(), empresa);
        DaoFactory.getFactory().eventoDao().save(evento);
        return evento.getId();
    }

    public List<EventoNombreDescripcionDto> readAll() {
        return DaoFactory.getFactory().eventoDao().findAll().stream().map(
                evento -> new EventoNombreDescripcionDto(evento)
        ).collect(Collectors.toList());
    }

    public void delete(String id) {
        DaoFactory.getFactory().eventoDao().deleteById(id);
    }

    public void createHorario(String eventoId, HorarioDto horarioDto) {
        Evento evento = DaoFactory.getFactory().eventoDao().read(eventoId)
                .orElseThrow(() -> new NotFoundException("Evento (" + eventoId + ")"));
        evento.getHorarios().add(new Horario(horarioDto.getInicio(), horarioDto.getFin()));
        DaoFactory.getFactory().eventoDao().save(evento);
    }

    public List<EventoNombreDescripcionDto> findByEstado(Boolean value) {
        return DaoFactory.getFactory().eventoDao().findAll().stream()
                .filter(evento -> evento.isEstado() == value)
                .map(EventoNombreDescripcionDto::new)
                .collect(Collectors.toList());
    }
}
