package JuegoBatallaNaval.controlador;

import JuegoBatallaNaval.modelo.Partida;
import JuegoBatallaNaval.modelo.Reporte;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

public class ControladorReporte {
    
    public boolean generarReporte(Partida partida, String resumen) {
        if (partida == null) {
            System.err.println("Error: No se puede generar reporte sin una partida.");
            return false;
        }
        
        try {
            Reporte reporte = new Reporte(partida, resumen);
            String nombreArchivo = "Reporte_" + new Date().getTime() + ".txt";
            
            String infoJugadores = partida.getJugador1().getUsername() + " vs " + partida.getJugador2().getUsername();

            try (PrintWriter out = new PrintWriter(new FileWriter(nombreArchivo))) {
                out.println("--- REPORTE DE PARTIDA DE BATALLA NAVAL ---");
                out.println(reporte.generarResumen());
                out.println("Partida registrada por: " + infoJugadores); 
                out.println("---------------------------------------------");
                System.out.println("Reporte guardado en: " + nombreArchivo);
                return true;
            }
        } catch (IOException e) {
            System.err.println("Error al guardar el reporte: " + e.getMessage());
            return false;
        }
    }
}