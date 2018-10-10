package api.dtos;

import api.entities.Empresa;
import api.entities.Horario;
import api.entities.TipoEvento;

import java.util.List;

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

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public TipoEvento getTipoEvento() {
        return tipoEvento;
    }

    public void setTipoEvento(TipoEvento tipoEvento) {
        this.tipoEvento = tipoEvento;
    }

    public String getEmpresaId() {
        return empresaId;
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