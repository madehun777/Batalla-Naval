//clase para gestionar la persistencia de los datos de Usuario (S)
package JuegoBatallaNaval.controlador;

import JuegoBatallaNaval.modelo.Usuario;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ControladorArchivoUsuario {

    // MEJORA DE CONCURRENCIA (SOLID)
    // Usar una colección sincronizada para asegurar Thread-Safety
    private static final List<Usuario> usuariosAlmacenados = 
            Collections.synchronizedList(new ArrayList<>());
    
    public ControladorArchivoUsuario() {
        // Inicializar con un usuario de prueba si está vacío
        if (usuariosAlmacenados.isEmpty()) {
            usuariosAlmacenados.add(new Usuario("Admin Principal", "admin", "1234"));
        }
    }

    // Usar synchronized para garantizar atomicidad en la escritura
    public synchronized void guardarUsuario(Usuario u) {
        usuariosAlmacenados.add(u);
    }

    // Usar synchronized para garantizar atomicidad en la lectura
    public synchronized Usuario buscarUsuario(String username) {
        for (Usuario u : usuariosAlmacenados) {
            if (u.getUsername().equals(username)) {
                return u;
            }
        }
        return null;
    }
    
    // Usar synchronized para garantizar atomicidad en la carga y ordenamiento
    public synchronized List<Usuario> cargarRanking() {
        // Clonar la lista para poder ordenarla sin modificar el almacenamiento original
        List<Usuario> ranking = new ArrayList<>(usuariosAlmacenados);
        
        // Ordenar por Puntuación Total de forma descendente
        ranking.sort(Comparator.comparingInt(Usuario::getPuntuacionTotal).reversed());
        
        return ranking;
    }
}