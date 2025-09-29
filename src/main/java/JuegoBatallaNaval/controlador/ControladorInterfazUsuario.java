//Gestionar la navegación (S)
//Depende de la lógica de ControladorUsuario, no de cómo se guarda el archivo. (D)
package JuegoBatallaNaval.controlador;

import JuegoBatallaNaval.modelo.Usuario;
import JuegoBatallaNaval.vista.VistaMenuPrincipal;
import JuegoBatallaNaval.vista.VistaPrincipal;
import JuegoBatallaNaval.vista.VistaRegistroLogin;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame; 

public class ControladorInterfazUsuario implements ActionListener {

    //instancias de la Vista
    private VistaPrincipal vistaPrincipal;
    private VistaRegistroLogin vistaRegistroLogin;
    private VistaMenuPrincipal vistaMenuPrincipal;
    
    //instancia del Modelo (Lógica de Negocio)
    private ControladorUsuario controladorUsuario; 
    
    private Usuario usuarioActual; 

    public ControladorInterfazUsuario(ControladorUsuario controladorUsuario) {
        // Inyección de Dependencia (DIP)
        this.controladorUsuario = controladorUsuario;
        
        // Inicialización de Vistas
        this.vistaPrincipal = new VistaPrincipal();
        this.vistaRegistroLogin = new VistaRegistroLogin();
        this.vistaMenuPrincipal = new VistaMenuPrincipal();
        
        // Asignación de Listeners
        this.vistaPrincipal.getBtnIniciarSesion().addActionListener(this);
        this.vistaPrincipal.getBtnRegistrarse().addActionListener(this);
        
        this.vistaRegistroLogin.getBtnAccion().addActionListener(this);
        this.vistaRegistroLogin.getBtnVolver().addActionListener(this);
        
        this.vistaMenuPrincipal.getBtnCerrarSesion().addActionListener(this);
    }

    public void iniciar() {
        mostrarVista(vistaPrincipal);
    }
    
    private void mostrarVista(JFrame vistaAMostrar) {
        // Cumple SRP: su única responsabilidad es gestionar la visibilidad de la GUI
        vistaPrincipal.setVisible(false);
        vistaRegistroLogin.setVisible(false);
        vistaMenuPrincipal.setVisible(false);
        
        vistaAMostrar.setLocationRelativeTo(null);
        vistaAMostrar.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // --- Eventos de VistaPrincipal ---
        if (e.getSource() == vistaPrincipal.getBtnIniciarSesion()) {
            vistaRegistroLogin.setModoLogin();
            vistaRegistroLogin.limpiarCampos();
            mostrarVista(vistaRegistroLogin);
        } else if (e.getSource() == vistaPrincipal.getBtnRegistrarse()) {
            vistaRegistroLogin.setModoRegistro();
            vistaRegistroLogin.limpiarCampos();
            mostrarVista(vistaRegistroLogin);
        }
        
        // --- Eventos de VistaRegistroLogin ---
        else if (e.getSource() == vistaRegistroLogin.getBtnAccion()) {
            if (vistaRegistroLogin.getBtnAccion().getText().equals("Registrar")) {
                registrarUsuario();
            } else { 
                iniciarSesion();
            }
        } else if (e.getSource() == vistaRegistroLogin.getBtnVolver()) {
            mostrarVista(vistaPrincipal);
        }
        
        // --- Eventos de VistaMenuPrincipal ---
        else if (e.getSource() == vistaMenuPrincipal.getBtnCerrarSesion()) {
            usuarioActual = null; 
            mostrarVista(vistaPrincipal);
        }
    }

    private void registrarUsuario() {
        String nombre = vistaRegistroLogin.getTxtNombre().getText();
        String username = vistaRegistroLogin.getTxtCorreo().getText();
        String password = new String(vistaRegistroLogin.getTxtContrasena().getPassword());

        if (nombre.isEmpty() || username.isEmpty() || password.isEmpty()) {
            vistaRegistroLogin.getLblMensaje().setText("Error: Llene todos los campos.");
            return;
        }

        boolean exito = controladorUsuario.crearUsuario(nombre, username, password);

        if (exito) {
            vistaRegistroLogin.getLblMensaje().setText("¡Registro exitoso! Por favor, inicie sesión.");
            // Esto cumple el OCP (Open/Closed Principle): la acción de registro está abierta a extensión
        } else {
            vistaRegistroLogin.getLblMensaje().setText("Error: El correo/usuario ya existe.");
        }
    }

    private void iniciarSesion() {
        String username = vistaRegistroLogin.getTxtCorreo().getText();
        String password = new String(vistaRegistroLogin.getTxtContrasena().getPassword());

        Usuario usuarioLogeado = controladorUsuario.verificarLogin(username, password);

        if (usuarioLogeado != null) {
            usuarioActual = usuarioLogeado;
            // Usar el nombre del usuario para personalizar la vista (como en la Imagen 3)
            vistaMenuPrincipal.setTitle("Menú Principal - " + usuarioActual.getNombre());
            mostrarVista(vistaMenuPrincipal);
            vistaRegistroLogin.limpiarCampos();
        } else {
            vistaRegistroLogin.getLblMensaje().setText("Error: Correo o contraseña incorrectos.");
        }
    }
}