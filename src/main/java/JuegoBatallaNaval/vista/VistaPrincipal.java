package JuegoBatallaNaval.vista;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle;
import javax.swing.SwingConstants;

public class VistaPrincipal extends JFrame {

    // Componentes que necesita el Controlador (deben ser variables de instancia)
    private JButton btnIniciarSesion;
    private JButton btnRegistrarse;
    private JLabel lblTitulo; 

    public VistaPrincipal() {
        initComponents();
        personalizarEstilo(); 
    }
    
    // Método para aplicar estilos como en las imágenes (fondo azul oscuro)
    private void personalizarEstilo() {
        getContentPane().setBackground(new Color(60, 120, 150)); // Fondo azul verdoso oscuro
        lblTitulo.setForeground(Color.WHITE); 
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 48)); 
        lblTitulo.setHorizontalAlignment(SwingConstants.CENTER); 
        
        // Estilo para los botones (azul claro)
        Color buttonColor = new Color(150, 200, 225);
        
        btnIniciarSesion.setBackground(buttonColor); 
        btnIniciarSesion.setForeground(Color.BLACK);
        btnIniciarSesion.setFont(new Font("Arial", Font.BOLD, 18));
        btnIniciarSesion.setBorderPainted(false);
        
        btnRegistrarse.setBackground(buttonColor); 
        btnRegistrarse.setForeground(Color.BLACK);
        btnRegistrarse.setFont(new Font("Arial", Font.BOLD, 18));
        btnRegistrarse.setBorderPainted(false);
    }

    // Código MÍNIMO para inicializar componentes (ajustado al diseño visual)
    private void initComponents() {
        lblTitulo = new JLabel();
        btnIniciarSesion = new JButton();
        btnRegistrarse = new JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Batalla Naval - Inicio");
        
        lblTitulo.setText("Batalla Naval");
        btnIniciarSesion.setText("Inicia sesión");
        btnRegistrarse.setText("Regístrese");
        
        // Uso de GroupLayout para centrar elementos
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                    .addComponent(lblTitulo, GroupLayout.PREFERRED_SIZE, 300, GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnIniciarSesion, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRegistrarse, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE))
                .addContainerGap(50, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addComponent(lblTitulo, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(btnIniciarSesion, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(btnRegistrarse, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(70, Short.MAX_VALUE))
        );
        pack();
    }
    
    // --- GETTERS para el ControladorInterfazUsuario ---
    public JButton getBtnIniciarSesion() {
        return btnIniciarSesion;
    }

    public JButton getBtnRegistrarse() {
        return btnRegistrarse;
    }
}