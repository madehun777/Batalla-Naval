package JuegoBatallaNaval.modelo;
public class Partida {
    // Atributos definidos en el diagrama UML
    private Usuario jugador1;
    private Usuario jugador2;
    private Usuario ganador; // El ganador de la partida
    private int rondasJugadas;
    private String resumenPartida;
    
    // Constructor básico (puedes completarlo más tarde)
    public Partida(Usuario j1, Usuario j2) {
        this.jugador1 = j1;
        this.jugador2 = j2;
        this.rondasJugadas = 0;
        this.resumenPartida = "";
    }
    
    // --- Métodos necesarios para corregir los errores de compilación ---
    
    // Método para obtener el primer jugador (usado en ControladorReporte)
    public Usuario getJugador1() {
        return jugador1;
    }
    
    // Método para obtener el segundo jugador (usado en ControladorReporte)
    public Usuario getJugador2() {
        return jugador2;
    }
    
    // Método para obtener el ganador (usado en Reporte.java)
    public Usuario getGanador() {
        return ganador;
    }
    
    // --- Otros Getters y Setters necesarios ---
    
    public int getRondasJugadas() {
        return rondasJugadas;
    }

    public void setRondasJugadas(int rondasJugadas) {
        this.rondasJugadas = rondasJugadas;
    }

    public String getResumenPartida() {
        return resumenPartida;
    }

    public void setResumenPartida(String resumenPartida) {
        this.resumenPartida = resumenPartida;
    }
    
    public void setGanador(Usuario ganador) {
        this.ganador = ganador;
    }
    
    // Métodos del diagrama UML (solo estructura por ahora)
    public boolean verificarFinPartida() {
        // Lógica de juego...
        return false;
    }
    
    public String verificarGanador() {
        // Lógica de juego...
        return "";
    }
}