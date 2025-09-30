package controlador;

import modelo.Usuario;
import modelo.Barco;
import modelo.Tablero;
import vista.VistaColocacion;
import vista.VistaTablero;

import javax.swing.*;
import java.util.concurrent.*;

public class ControladorColocacion {

    private Usuario usuario;
    private VistaColocacion vista;
    private ExecutorService executor;

    public ControladorColocacion(Usuario usuario) {
        this.usuario = usuario;
        this.vista = new VistaColocacion(usuario);
        this.executor = Executors.newFixedThreadPool(2);
        inicializarDropListener();
    }

    private void inicializarDropListener() {
        VistaTablero vt = vista.getVistaTablero();
        Tablero tablero = usuario.getTablero();

        vt.setDropListener((tipo, tamano, fila, col) -> {
            Barco barco = new Barco(tipo, tamano);
            String orientacion = vista.getOrientacionSeleccionada();

            boolean ok = validarColocacionConHilos(barco, fila, col, orientacion, tablero);

            if (ok) {
                if (tablero.colocarBarco(barco, fila, col, orientacion)) {
                    vt.actualizar();
                    vista.marcarBarcoColocado(barco);
                }
            } else {
                JOptionPane.showMessageDialog(vista, "No se puede colocar aquí");
            }
        });
    }

    private boolean validarColocacionConHilos(Barco barco, int fila, int col, String orientacion, Tablero tablero) {
        Future<Boolean> limitesFuture = executor.submit(() -> {
            int tam = barco.getTamano();
            return orientacion.equals("H")
                    ? col + tam <= tablero.getDimension()
                    : fila + tam <= tablero.getDimension();
        });

        Future<Boolean> espacioFuture = executor.submit(() ->
                tablero.esPosicionValida(barco, fila, col, orientacion)
        );

        try {
            return limitesFuture.get() && espacioFuture.get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
            return false;
        }
    }
}
