package com.mycompany.batallanaval.modelo;
public class Usuario {
    private String nombre;
    private int partidasGanadas;
    private int partidasPerdidas;
    private int puntosVictorias;

    public Usuario(String nombre) {
        this.nombre = nombre;
        this.partidasGanadas = 0;
        this.partidasPerdidas = 0;
        this.puntosVictorias = 0;
    }

    public void agregarVictoria() {
        partidasGanadas++;
    }

    public void agregarDerrota() {
        partidasPerdidas++;
    }

    public void sumarPuntosUsuario(int puntos) {
        puntosVictorias += puntos;
    }

    public String getEstadisticas() {
        return "Usuario: " + nombre +
               "\nGanadas: " + partidasGanadas +
               "\nPerdidas: " + partidasPerdidas +
               "\nPuntos: " + puntosVictorias;
    }

    public String getNombre() {
        return nombre;
    }
}

