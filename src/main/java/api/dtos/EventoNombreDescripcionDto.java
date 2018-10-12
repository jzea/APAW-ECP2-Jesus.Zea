package api.dtos;
import api.entities.Evento;
public class EventoNombreDescripcionDto {
    private String nombre;
    private String descripcion;

    public EventoNombreDescripcionDto(Evento evento) {
        this.nombre = evento.getNombre();
        this.descripcion = evento.getDescripcion();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "EventoNombreDescripcionDto{" +
                "nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }
}
