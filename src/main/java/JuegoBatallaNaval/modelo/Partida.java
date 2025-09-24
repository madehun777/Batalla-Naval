package JuegoBatallaNaval.modelo;

import java.time.LocalDateTime;

public class Partida {
    private Usuario jugador;
    private LocalDateTime fecha;
    private boolean ganada;

    public Partida(Usuario jugador) {
        this.jugador = jugador;
        this.fecha = LocalDateTime.now();
        this.ganada = false;
    }

    public Usuario getJugador() {
        return jugador;
    }

    public void setJugador(Usuario jugador) {
        this.jugador = jugador;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public boolean isGanada() {
        return ganada;
    }

    public void setGanada(boolean ganada) {
        this.ganada = ganada;
    }

    @Override
    public String toString() {
        return "Partida{" +
                "jugador=" + jugador +
                ", fecha=" + fecha +
                ", ganada=" + ganada +
                '}';
    }
}
