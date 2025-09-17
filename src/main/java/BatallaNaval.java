package com.mycompany.batallanaval;
import com.mycompany.batallanaval.vista.InterfazGrafica;
import javax.swing.SwingUtilities;

public class BatallaNaval {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            InterfazGrafica ventana = new InterfazGrafica();
            ventana.setVisible(true);
        });
    }
}
