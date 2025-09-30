package modelo;

import java.util.ArrayList;
import java.util.List;

public class Barco {
    private String tipo;
    private int tamano;
    private String orientacion; // "H" o "V"
    private int fila;
    private int columna;
    private boolean colocado;
    private List<boolean[]> partes; // cada parte del barco: true = intacto, false = impactado

    public Barco(String tipo, int tamano) {
        this.tipo = tipo;
        this.tamano = tamano;
        this.colocado = false;
        this.partes = new ArrayList<>();
    }

    public String getTipo() {
        return tipo;
    }

    public int getTamano() {
        return tamano;
    }

    public String getOrientacion() {
        return orientacion;
    }

    public void setOrientacion(String orientacion) {
        this.orientacion = orientacion;
    }

    public void colocar(int fila, int columna, String orientacion) {
        this.fila = fila;
        this.columna = columna;
        this.orientacion = orientacion;
        this.colocado = true;

        // inicializa partes (todas intactas)
        this.partes.clear();
        for (int i = 0; i < tamano; i++) {
            this.partes.add(new boolean[]{true});
        }
    }

    public boolean isColocado() {
        return colocado;
    }

    public boolean ocupa(int f, int c) {
        if (!colocado) return false;

        if (orientacion.equals("H")) {
            return f == fila && c >= columna && c < columna + tamano;
        } else { // "V"
            return c == columna && f >= fila && f < fila + tamano;
        }
    }

    public void impactar(int f, int c) {
        if (!ocupa(f, c)) return;

        if (orientacion.equals("H")) {
            int index = c - columna;
            partes.get(index)[0] = false;
        } else {
            int index = f - fila;
            partes.get(index)[0] = false;
        }
    }

    public boolean estaHundido() {
        for (boolean[] parte : partes) {
            if (parte[0]) return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return tipo + " (" + tamano + " casillas)";
    }
}


