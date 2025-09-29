package JuegoBatallaNaval.vista;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.GroupLayout;
import javax.swing.SwingConstants;

public class VistaMenuPrincipal extends JFrame {

    // Componentes que necesita el Controlador
    private JButton btnCerrarSesion;
    private JButton btnJugar;
    private JButton btnLeaderboard;
    private JLabel lblTitulo; // Título que se cambia al iniciar sesión

    public VistaMenuPrincipal() {
        initComponents();
        personalizarEstilo();
    }
    
    // Método para aplicar estilos (fondo azul muy claro)
    private void personalizarEstilo() {
        getContentPane().setBackground(new Color(175, 225, 245)); // Fondo azul muy claro
        
        lblTitulo.setForeground(Color.WHITE); 
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 48));
        lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        
        // Estilo de los botones (azul oscuro)
        Color buttonColor = new Color(75, 125, 150);
        
        btnJugar.setBackground(buttonColor);
        btnJugar.setForeground(Color.WHITE);
        btnJugar.setFont(new Font("Arial", Font.BOLD, 18));
        btnJugar.setBorderPainted(false);
        
        btnLeaderboard.setBackground(buttonColor);
        btnLeaderboard.setForeground(Color.WHITE);
        btnLeaderboard.setFont(new Font("Arial", Font.BOLD, 18));
        btnLeaderboard.setBorderPainted(false);
        
        btnCerrarSesion.setBackground(buttonColor);
        btnCerrarSesion.setForeground(Color.WHITE);
        btnCerrarSesion.setFont(new Font("Arial", Font.BOLD, 18));
        btnCerrarSesion.setBorderPainted(false);
    }

    // Código MÍNIMO para inicializar componentes
    private void initComponents() {
        lblTitulo = new JLabel();
        btnJugar = new JButton();
        btnLeaderboard = new JButton();
        btnCerrarSesion = new JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Batalla Naval - Menú Principal");

        lblTitulo.setText("Batalla Naval");
        btnJugar.setText("Jugar");
        btnLeaderboard.setText("Leaderboard");
        btnCerrarSesion.setText("Cerrar Sesión");

        // Uso de GroupLayout para centrar elementos
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                    .addComponent(lblTitulo, GroupLayout.PREFERRED_SIZE, 300, GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnJugar, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLeaderboard, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCerrarSesion, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE))
                .addContainerGap(50, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(lblTitulo, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(btnJugar, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(btnLeaderboard, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(btnCerrarSesion, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(50, Short.MAX_VALUE))
        );
        pack();
    }
    
    // --- GETTERS para el ControladorInterfazUsuario ---
    public JButton getBtnJugar() {
        return btnJugar;
    }

    public JButton getBtnLeaderboard() {
        return btnLeaderboard;
    }

    public JButton getBtnCerrarSesion() {
        return btnCerrarSesion;
    }
    
    // Getter especial para actualizar el título (usado por el controlador al hacer login)
    public JLabel getLblTitulo() {
        return lblTitulo;
    }
}