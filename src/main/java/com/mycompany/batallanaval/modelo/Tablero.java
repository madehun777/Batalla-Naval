package modelo;

import java.util.ArrayList;
import java.util.List;

public class Tablero {
    private int dimension;
    private char[][] celdas;
    private List<Barco> barcos;

    public Tablero(int dimension) {
        this.dimension = dimension;
        this.celdas = new char[dimension][dimension];
        this.barcos = new ArrayList<>();
        inicializar();
    }

    private void inicializar() {
        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                celdas[i][j] = '~'; // agua
            }
        }
    }

    public boolean esLibre(int fila, int columna) {
        return celdas[fila][columna] == '~';
    }

    public void ocupar(int fila, int columna) {
        celdas[fila][columna] = 'B';
    }

    public void agregarBarco(Barco barco) {
        barcos.add(barco);
    }

    public int getDimension() {
        return dimension;
    }

    public char[][] getCeldas() {
        return celdas;
    }

    public void imprimir() {
        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                System.out.print(celdas[i][j] + " ");
            }
            System.out.println();
        }
    }
    
    public boolean colocarBarco(Barco barco, int fila, int col, String orientacion) {
    int tam = barco.getTamano();
    // Validación de límites y ocupación (por seguridad)
    if (orientacion.equals("H")) {
        if (col + tam > dimension) return false;
        for (int j = 0; j < tam; j++) {
            if (!esLibre(fila, col + j)) return false;
        }
        for (int j = 0; j < tam; j++) {
            ocupar(fila, col + j);
        }
    } else { // vertical
        if (fila + tam > dimension) return false;
        for (int i = 0; i < tam; i++) {
            if (!esLibre(fila + i, col)) return false;
        }
        for (int i = 0; i < tam; i++) {
            ocupar(fila + i, col);
        }
    }
    barco.colocar(fila, col, orientacion);
    agregarBarco(barco);
    return true;
    }
    
    public boolean esPosicionValida(Barco barco, int fila, int col, String orientacion) {
    int tam = barco.getTamano();
    if (orientacion.equals("H")) {
        if (col + tam > dimension) return false;
        for (int j = 0; j < tam; j++) {
            if (!esLibre(fila, col + j)) return false;
        }
    } else {
        if (fila + tam > dimension) return false;
        for (int i = 0; i < tam; i++) {
            if (!esLibre(fila + i, col)) return false;
        }
    }
    return true;
    }

}
