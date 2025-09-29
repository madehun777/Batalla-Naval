//está abierto a la extensión (nuevos modos de acción) mediante métodos utilitarios (O)
package JuegoBatallaNaval.vista;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Font;
import javax.swing.GroupLayout;
import javax.swing.JPanel; // Importación necesaria
import javax.swing.SwingConstants;
import javax.swing.LayoutStyle; // Importación necesaria

public class VistaRegistroLogin extends JFrame {

    // 1. CORRECCIÓN PRINCIPAL: DECLARAR TODOS LOS COMPONENTES COMO ATRIBUTOS DE CLASE
    private JButton btnAccion; 
    private JButton btnVolver;
    private JLabel lblContrasena; // <--- CORREGIDO: Ahora es atributo
    private JLabel lblCorreo;     // <--- CORREGIDO: Ahora es atributo
    private JLabel lblMensaje;
    private JLabel lblNombre;
    private JLabel lblTituloAccion; 
    private JTextField txtNombre;
    private JPasswordField txtContrasena;
    private JTextField txtCorreo; 
    private JPanel panelContenedor; // <--- Nuevo atributo para acceder al fondo oscuro

    public VistaRegistroLogin() {
        initComponents();
        personalizarEstilo();
    }

    private void personalizarEstilo() {
        getContentPane().setBackground(new Color(175, 225, 245)); // Fondo azul claro
        
        lblTituloAccion.setForeground(Color.BLACK); 
        lblTituloAccion.setFont(new Font("Arial", Font.BOLD, 36));
        lblTituloAccion.setHorizontalAlignment(SwingConstants.CENTER);
        
        // CORRECCIÓN 2: Acceder al panelContenedor directamente, ya no se requiere casting complejo
        panelContenedor.setBackground(new Color(60, 120, 150)); // Azul oscuro del panel central
        
        // Estilo de las etiquetas (labels) - Acceso directo a los atributos
        lblNombre.setForeground(Color.WHITE);
        lblCorreo.setForeground(Color.WHITE); // <--- CORREGIDO
        lblContrasena.setForeground(Color.WHITE); // <--- CORREGIDO
        
        // Estilo de los campos de texto
        Color fieldColor = new Color(150, 200, 225);
        txtNombre.setBackground(fieldColor);
        txtCorreo.setBackground(fieldColor);
        txtContrasena.setBackground(fieldColor);
        
        // Estilo de los botones
        btnAccion.setBackground(new Color(75, 125, 150));
        btnAccion.setForeground(Color.WHITE);
        btnVolver.setBackground(new Color(75, 125, 150));
        btnVolver.setForeground(Color.WHITE);
        
        lblMensaje.setForeground(Color.RED); 
    }
    
    // Método de utilidad para el ControladorInterfazUsuario
    public void setModoRegistro() { //permiten que el controlador cambie el comportamiento de la vista sin modificar su estructura interna (initComponents()).
        lblTituloAccion.setText("¡Regístrate!");
        lblNombre.setVisible(true); 
        txtNombre.setVisible(true);
        btnAccion.setText("Registrar");
        pack();
    }

    // Método de utilidad para el ControladorInterfazUsuario
    public void setModoLogin() {
        lblTituloAccion.setText("¡Inicia Sesión!");
        lblNombre.setVisible(false); 
        txtNombre.setVisible(false);
        btnAccion.setText("Iniciar Sesión");
        pack();
    }

    private void initComponents() {
        
        // Inicializar los atributos de clase aquí
        panelContenedor = new JPanel(); 
        lblTituloAccion = new JLabel();
        lblNombre = new JLabel();
        txtNombre = new JTextField(20);
        lblCorreo = new JLabel();         // <--- Inicialización de atributo
        txtCorreo = new JTextField(20);
        lblContrasena = new JLabel();     // <--- Inicialización de atributo
        txtContrasena = new JPasswordField(20);
        btnAccion = new JButton();
        btnVolver = new JButton("Volver");
        lblMensaje = new JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Acceso de Usuario");

        // Configuración básica de texto
        lblTituloAccion.setText("Acción de Usuario"); 
        lblNombre.setText("Nombre");
        lblCorreo.setText("Correo");        // <--- Acceso a atributo
        lblContrasena.setText("Contraseña"); // <--- Acceso a atributo
        btnAccion.setText("Accionar"); 

        // Diseño del panel interior (simulando la caja oscura)
        GroupLayout panelContenedorLayout = new GroupLayout(panelContenedor);
        panelContenedor.setLayout(panelContenedorLayout);
        panelContenedorLayout.setHorizontalGroup(
            panelContenedorLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(panelContenedorLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(panelContenedorLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(lblNombre)
                    .addComponent(txtNombre, GroupLayout.PREFERRED_SIZE, 300, GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCorreo) // <--- Acceso a atributo
                    .addComponent(txtCorreo, GroupLayout.PREFERRED_SIZE, 300, GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblContrasena) // <--- Acceso a atributo
                    .addComponent(txtContrasena, GroupLayout.PREFERRED_SIZE, 300, GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAccion, GroupLayout.PREFERRED_SIZE, 300, GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnVolver, GroupLayout.PREFERRED_SIZE, 300, GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblMensaje, GroupLayout.PREFERRED_SIZE, 300, GroupLayout.PREFERRED_SIZE))
                .addContainerGap(40, Short.MAX_VALUE))
        );
        panelContenedorLayout.setVerticalGroup(
            panelContenedorLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(panelContenedorLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(lblNombre)
                .addComponent(txtNombre, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblCorreo) // <--- Acceso a atributo
                .addComponent(txtCorreo, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblContrasena) // <--- Acceso a atributo
                .addComponent(txtContrasena, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(btnAccion, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnVolver, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblMensaje)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        // Diseño del JFrame principal
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblTituloAccion, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelContenedor, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addContainerGap(50, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(lblTituloAccion, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(panelContenedor, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        pack();
    }
    
    // --- GETTERS para el ControladorInterfazUsuario ---
    public JButton getBtnAccion() {return btnAccion;}
    public JButton getBtnVolver() {return btnVolver;}
    public JTextField getTxtNombre() {return txtNombre;}
    public JTextField getTxtCorreo() {return txtCorreo;}
    public JPasswordField getTxtContrasena() {return txtContrasena;}
    public JLabel getLblMensaje() {return lblMensaje;}
    
    public void limpiarCampos() {
        txtNombre.setText("");
        txtCorreo.setText("");
        txtContrasena.setText("");
        lblMensaje.setText("");
    }
}