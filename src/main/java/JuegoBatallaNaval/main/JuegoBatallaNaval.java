//Ensambla las dependencias sin conocer los detalles internos (D)
package JuegoBatallaNaval.main;

import JuegoBatallaNaval.controlador.ControladorInterfazUsuario;
import JuegoBatallaNaval.controlador.ControladorUsuario;
import javax.swing.SwingUtilities;
public class JuegoBatallaNaval {
    
    public static void main(String[] args) {
        // Concurrencia: Asegura que la GUI se inicialice y ejecute en el EDT.
        SwingUtilities.invokeLater(() -> {
            // 1. Instanciar el Controlador de Dominio (Modelo)
            ControladorUsuario controladorUsuario = new ControladorUsuario();
            
            // 2. Instanciar el Controlador de la Interfaz (Vista)
            ControladorInterfazUsuario controladorInterfaz = 
                    new ControladorInterfazUsuario(controladorUsuario);
            
            // 3. Iniciar la aplicación
            controladorInterfaz.iniciar();
        });
    }
}