package api.entities;

import java.time.LocalDateTime;

public class Horario {
    private String id;
    private LocalDateTime inicio;
    private LocalDateTime fin;

    public Horario(String id, LocalDateTime inicio, LocalDateTime fin) {
        this.id = id;
        this.inicio = inicio;
        this.fin = fin;
    }

    public LocalDateTime getInicio() {
        return inicio;
    }

    public void setInicio(LocalDateTime inicio) {
        this.inicio = inicio;
    }

    public LocalDateTime getFin() {
        return fin;
    }

    public void setFin(LocalDateTime fin) {
        this.fin = fin;
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Horario{" +
                "id='" + id + '\'' +
                ", inicio=" + inicio +
                ", fin=" + fin +
                '}';
    }
}
