package api.dtos;

import api.entities.TipoEvento;


public class EventoDto {

    private String nombre;
    private String descripcion;
    private boolean estado;
    private TipoEvento tipoEvento;
    private String empresaId;

    public EventoDto(String nombre, String descripcion, boolean estado, TipoEvento tipoEvento, String empresaId) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.estado = estado;
        this.empresaId = empresaId;
        this.tipoEvento = tipoEvento;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public boolean isEstado() {
        return estado;
    }

    public TipoEvento getTipoEvento() {
        return tipoEvento;
    }

    public String getEmpresaId() {
        return empresaId;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public void setTipoEvento(TipoEvento tipoEvento) {
        this.tipoEvento = tipoEvento;
    }

    public void setEmpresaId(String empresaId) {
        this.empresaId = empresaId;
    }

    @Override
    public String toString() {
        return "EventoDto{" +
                "nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", estado=" + estado +
                ", tipoEvento=" + tipoEvento +
                ", empresaId=" + empresaId +
                '}';
    }
}