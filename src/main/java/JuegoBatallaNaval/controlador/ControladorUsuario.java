package JuegoBatallaNaval.controlador;

import JuegoBatallaNaval.modelo.Usuario;
import java.util.ArrayList;
import java.util.List;

public class ControladorUsuario {
    private List<Usuario> usuarios;

    public ControladorUsuario() {
        this.usuarios = new ArrayList<>();
    }

    public void registrarUsuario(String nombre, int edad) {
        Usuario nuevo = new Usuario(nombre, edad);
        usuarios.add(nuevo);
        System.out.println("Usuario registrado: " + nuevo);
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }
}
