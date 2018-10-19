package api.entities;

import java.util.ArrayList;
import java.util.List;

public class Evento {

    private String id;
    private String nombre;
    private String descripcion;
    private boolean estado;
    private float costo;
    private List<Horario> horarios;
    private TipoEvento tipoEvento;
    private Empresa empresa;

    public Evento(String nombre, String descripcion, boolean estado, TipoEvento tipoEvento, Empresa empresa) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.estado = estado;
        this.tipoEvento = tipoEvento;
        this.empresa = empresa;
        this.horarios = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public float getCosto() {
        return costo;
    }

    public void setCosto(float costo) {
        this.costo = costo;
    }

    public List<Horario> getHorarios() {
        return horarios;
    }

    public void setHorarios(List<Horario> horarios) {
        this.horarios = horarios;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public TipoEvento getTipoEvento() {
        return tipoEvento;
    }

    public void setTipoEvento(TipoEvento tipoEvento) {
        this.tipoEvento = tipoEvento;
    }

    @Override
    public String toString() {
        return "Evento{" +
                "id='" + id + '\'' +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", estado=" + estado +
                ", costo=" + costo +
                ", horarios=" + horarios +
                ", tipoEvento=" + tipoEvento +
                ", empresa=" + empresa +
                '}';
    }
}
