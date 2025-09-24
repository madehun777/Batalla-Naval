package JuegoBatallaNaval.main;

import javax.swing.SwingUtilities;
import JuegoBatallaNaval.vista.InterfazUsuario;

public class JuegoBatallaNaval {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            InterfazUsuario interfaz = new InterfazUsuario();
            interfaz.setVisible(true);
        });
    }
}
