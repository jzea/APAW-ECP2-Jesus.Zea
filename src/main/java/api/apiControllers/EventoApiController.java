package api.apiControllers;

import api.exceptions.ArgumentNotValidException;
import api.dtos.EventoDto;
import api.businessController.EventoBusinessController;
import api.dtos.EventoNombreDescripcionDto;

import java.util.List;

public class EventoApiController {

    public static final String EVENTOS = "/eventos";

    public static final String ID_ID = "/{id}";

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

    private void validate(Object property, String message) {
        if (property == null) {
            throw new ArgumentNotValidException(message + " is NULL");
        }
    }
}
