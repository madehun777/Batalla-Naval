package com.mycompany.batallanaval.controlador;
import com.mycompany.batallanaval.modelo.Usuario;
import java.util.ArrayList;
import java.util.List;

public class ControladorUsuario {
    private List<Usuario> usuarios;

    public ControladorUsuario() {
        this.usuarios = new ArrayList<>();
    }

    public Usuario crearUsuario(String nombre) {
        Usuario u = new Usuario(nombre);
        usuarios.add(u);
        return u;
    }

    public Usuario buscarUsuario(String nombre) {
        for (Usuario u : usuarios) {
            if (u.getNombre().equalsIgnoreCase(nombre)) {
                return u;
            }
        }
        return null;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }
}
