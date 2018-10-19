package api.apiControllers;

import api.dtos.HorarioDto;
import api.exceptions.ArgumentNotValidException;
import api.dtos.EventoDto;
import api.businessController.EventoBusinessController;
import api.dtos.EventoNombreDescripcionDto;

import java.util.List;

public class EventoApiController {

    public static final String EVENTOS = "/eventos";

    public static final String ID_ID = "/{id}";

    public static final String HORARIOS = "/horarios";

    public static final String SEARCH = "/search";

    private EventoBusinessController eventoBusinessController = new EventoBusinessController();

    public String create(EventoDto eventoDto) {
        this.validate(eventoDto, "eventoDto");
        this.validate(eventoDto.getNombre(), "eventoDto nombre");
        this.validate(eventoDto.getDescripcion(), "eventoDto descripcion");
        this.validate(eventoDto.isEstado(), "eventoDto estado");
        this.validate(eventoDto.getTipoEvento(), "eventoDto tipo evento");
        this.validate(eventoDto.getEmpresaId(), "eventoDto empresa id");
        return eventoBusinessController.create(eventoDto);
    }

    public List<EventoNombreDescripcionDto> readAll() {
        return this.eventoBusinessController.readAll();
    }

    public void delete(String id) {
        this.eventoBusinessController.delete(id);
    }

    public void createHorario(String eventoId, HorarioDto horarioDto) {
        this.validate(horarioDto.getInicio(), "horarioDto inicio");
        this.validate(horarioDto.getFin(), "horarioDto fin");
        this.eventoBusinessController.createHorario(eventoId, horarioDto);
    }

    public List<EventoNombreDescripcionDto> find(String query) {
        this.validate(query, "query param q");
        if (!"estado".equals(query.split(":=")[0])) {
            throw new ArgumentNotValidException("query param q is incorrect, missing 'estado:='");
        }
        return this.eventoBusinessController.findByEstado(Boolean.valueOf(query.split(":=")[1]));
    }

    private void validate(Object property, String message) {
        if (property == null) {
            throw new ArgumentNotValidException(message + " is NULL");
        }
    }
}
