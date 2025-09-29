package JuegoBatallaNaval.modelo;

import java.util.Date;

public class Reporte {
    private Date fecha;
    private Partida partida; 
    private String resumen;
    
    // Constructor
    public Reporte(Partida partida, String resumen) {
        this.fecha = new Date(); 
        this.partida = partida;
        this.resumen = resumen;
    }
    
    // Método de Lógica de Negocio (corregido para evitar NullPointerException)
    public String generarResumen() {
        String nombreGanador = (partida != null && partida.getGanador() != null) 
                               ? partida.getGanador().getNombre() : "N/A";

        return "Reporte de Partida del " + fecha.toString() + 
               "\nGanador: " + nombreGanador + 
               "\n" + this.resumen;
    }
    
    // --- Getters y Setters (los mismos que antes) ---

    public Date getFecha() {
        return fecha;
    }

    public Partida getPartida() {
        return partida;
    }

    public String getResumen() {
        return resumen;
    }
}