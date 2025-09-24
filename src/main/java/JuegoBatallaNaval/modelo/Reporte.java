package JuegoBatallaNaval.modelo;

import java.util.ArrayList;
import java.util.List;

public class Reporte {
    private List<Partida> partidas;

    public Reporte() {
        this.partidas = new ArrayList<>();
    }

    public void agregarPartida(Partida partida) {
        partidas.add(partida);
    }

    public List<Partida> getPartidas() {
        return partidas;
    }

    public void mostrarReporte() {
        System.out.println("===== Reporte de Partidas =====");
        for (Partida p : partidas) {
            System.out.println(p);
        }
    }
}
