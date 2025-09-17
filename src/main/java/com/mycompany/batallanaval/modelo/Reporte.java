package com.mycompany.batallanaval.modelo;
public class Reporte {
    private Partida partida;

    public Reporte(Partida partida) {
        this.partida = partida;
    }

    public String generarReporte() {
        return "=== REPORTE DE PARTIDA ===\n" +
               partida.resumenPartida();
    }

    public String generarResumen() {
        return "Ganador: " + partida.getGanador().getNombre() +
               " | Perdedor: " + partida.getPerdedor().getNombre();
    }
}
