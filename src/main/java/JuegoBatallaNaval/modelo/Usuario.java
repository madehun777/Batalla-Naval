//clase solo para almacenar datos y gestionar las estadísticas internas del jugador (S).
package JuegoBatallaNaval.modelo;

public class Usuario {
    private String nombre;
    private String username; // Usado para fines de identificación y login
    private String password; // NOTA: En la práctica, se debe hashear
    private int partidasJugadas;
    private int partidasGanadas;
    private int puntuacionTotal;

    // Constructor para el registro
    public Usuario(String nombre, String username, String password) {
        this.nombre = nombre;
        this.username = username;
        this.password = password;
        this.partidasJugadas = 0;
        this.partidasGanadas = 0;
        this.puntuacionTotal = 0;
    }

    // --- Métodos de Lógica de Negocio (del diagrama UML) ---

    public void agregarVictoria(int puntos) {
        this.partidasJugadas++;
        this.partidasGanadas++;
        this.puntuacionTotal += puntos;
    }

    public void perderPartida() {
        this.partidasJugadas++;
    }

    public String getEstadisticas() {
        return "Jugadas: " + partidasJugadas + ", Ganadas: " + partidasGanadas + ", Puntos: " + puntuacionTotal;
    }
    
    // --- Getters y Setters ---

    public String getNombre() {
        return nombre;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public int getPartidasJugadas() {
        return partidasJugadas;
    }

    public int getPartidasGanadas() {
        return partidasGanadas;
    }

    public int getPuntuacionTotal() {
        return puntuacionTotal;
    }
    
    // Setters (útiles para actualizar stats)
    public void setPartidasJugadas(int partidasJugadas) {
        this.partidasJugadas = partidasJugadas;
    }

    public void setPartidasGanadas(int partidasGanadas) {
        this.partidasGanadas = partidasGanadas;
    }

    public void setPuntuacionTotal(int puntuacionTotal) {
        this.puntuacionTotal = puntuacionTotal;
    }
}