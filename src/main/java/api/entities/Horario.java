package api.entities;

import java.time.LocalDateTime;

public class Horario {

    private LocalDateTime inicio;

    private LocalDateTime fin;

    public Horario(LocalDateTime inicio, LocalDateTime fin) {
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

    @Override
    public String toString() {
        return "Horario{" +
                "inicio=" + inicio +
                ", fin=" + fin +
                '}';
    }
}
