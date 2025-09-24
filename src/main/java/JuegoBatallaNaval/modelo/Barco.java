package JuegoBatallaNaval.modelo;
import java.util.ArrayList;
import java.util.List;

public class Barco {
    private final String tipo;
    private final int tamano;
    private int vidasRestantes;
    private final List<int[]> posiciones; // cada posición es [fila, columna]

    public Barco(String tipo, int tamano) {
        this.tipo = tipo;
        this.tamano = tamano;
        this.vidasRestantes = tamano;
        this.posiciones = new ArrayList<>();
    }

    public String getTipo() {
        return tipo;
    }

    public int getTamano() {
        return tamano;
    }

    public int getVidasRestantes() {
        return vidasRestantes;
    }

    public List<int[]> getPosiciones() {
        return posiciones;
    }

    public void asignarPosicion(int fila, int columna) {
        if (posiciones.size() < tamano) {
            posiciones.add(new int[]{fila, columna});
        }
    }

    public void recibirImpacto() {
        if (vidasRestantes > 0) {
            vidasRestantes--;
        }
    }

    public boolean estaHundido() {
        return vidasRestantes == 0;
    }
}

