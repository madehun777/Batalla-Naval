package modelo;

public class Tablero {
    private final int dimension;
    private final char[][] celdas;

    public Tablero(int dimension) {
        this.dimension = dimension;
        this.celdas = new char[dimension][dimension];
        inicializar();
    }

    private void inicializar() {
        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                celdas[i][j] = '~'; // agua
            }
        }
    }

    public void mostrarTablero() {
        System.out.print("   ");
        for (int j = 0; j < dimension; j++) {
            System.out.print(j + " ");
        }
        System.out.println();
        for (int i = 0; i < dimension; i++) {
            System.out.print(i + " | ");
            for (int j = 0; j < dimension; j++) {
                System.out.print(celdas[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void setCelda(int fila, int columna, char valor) {
        if (esValida(fila, columna)) {
            celdas[fila][columna] = valor;
        }
    }

    public char getCelda(int fila, int columna) {
        return esValida(fila, columna) ? celdas[fila][columna] : '?';
    }

    private boolean esValida(int fila, int columna) {
        return fila >= 0 && fila < dimension && columna >= 0 && columna < dimension;
    }
}