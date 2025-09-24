package JuegoBatallaNaval.controlador;

import JuegoBatallaNaval.modelo.Partida;
import JuegoBatallaNaval.modelo.Reporte;

public class ControladorReporte {
    private Reporte reporte;

    public ControladorReporte() {
        this.reporte = new Reporte();
    }

    public void agregarPartida(Partida partida) {
        reporte.agregarPartida(partida);
    }

    public void mostrarReporte() {
        reporte.mostrarReporte();
    }

    public Reporte getReporte() {
        return reporte;
    }
}
