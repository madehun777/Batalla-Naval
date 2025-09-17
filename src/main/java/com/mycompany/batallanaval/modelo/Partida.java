package com.mycompany.batallanaval.modelo;
import java.time.LocalDateTime;

public class Partida {
    private Usuario jugador1;
    private Usuario jugador2;
    private Usuario ganador;
    private Usuario perdedor;
    private LocalDateTime fecha;
    private int duracion; // minutos

    public Partida(Usuario jugador1, Usuario jugador2) {
        this.jugador1 = jugador1;
        this.jugador2 = jugador2;
        this.fecha = LocalDateTime.now();
    }

    public void finalizarPartida(Usuario ganador, Usuario perdedor, int duracion) {
        this.ganador = ganador;
        this.perdedor = perdedor;
        this.duracion = duracion;

        ganador.agregarVictoria();
        perdedor.agregarDerrota();
    }

    public String resumenPartida() {
        return "Partida entre " + jugador1.getNombre() + " y " + jugador2.getNombre() +
               "\nGanador: " + (ganador != null ? ganador.getNombre() : "N/A") +
               "\nDuración: " + duracion + " min" +
               "\nFecha: " + fecha;
    }

    public Usuario getGanador() { return ganador; }
    public Usuario getPerdedor() { return perdedor; }
}
