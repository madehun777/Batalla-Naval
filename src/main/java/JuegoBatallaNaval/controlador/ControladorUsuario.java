//controlador para gestionar la lógica de negocio de los usuarios (creación, login, ranking)(S)
//está cerrado a la modificación si cambia la persistencia (O)
package JuegoBatallaNaval.controlador;
import JuegoBatallaNaval.modelo.Usuario;
import java.util.List;

public class ControladorUsuario {
    
    //encapsulamiento
    private ControladorArchivoUsuario archivoUsuario;
    
    public ControladorUsuario() {
        this.archivoUsuario = new ControladorArchivoUsuario();
    }
    
    public boolean crearUsuario(String nombre, String username, String password) {
        if (archivoUsuario.buscarUsuario(username) == null) {
            Usuario nuevoUsuario = new Usuario(nombre, username, password);
            archivoUsuario.guardarUsuario(nuevoUsuario); //recibe y utiliza el resultado de archivoUsuario.guardarUsuario(). Si mañana ControladorArchivoUsuario es reemplazado por un ControladorBDUsuario que implementa una interfaz común, ControladorUsuario no cambia.
            return true;
        }
        return false;
    }
    
    public Usuario verificarLogin(String username, String password) {
        Usuario usuario = archivoUsuario.buscarUsuario(username);
        if (usuario != null && usuario.getPassword().equals(password)) {
            return usuario;
        }
        return null;
    }

    public List<Usuario> cargarRanking() {
        return archivoUsuario.cargarRanking();
    }
}