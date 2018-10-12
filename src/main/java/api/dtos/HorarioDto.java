package api.dtos;

import java.time.LocalDateTime;

public class HorarioDto {

    private LocalDateTime inicio;

    private LocalDateTime fin;

    public HorarioDto(LocalDateTime inicio, LocalDateTime fin) {
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
        return "HorarioDto{" +
                "inicio=" + inicio +
                ", fin=" + fin +
                '}';
    }
}
