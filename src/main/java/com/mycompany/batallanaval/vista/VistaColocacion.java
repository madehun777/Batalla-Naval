package vista;

import modelo.Usuario;
import modelo.Barco;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class VistaColocacion extends JFrame {
    private Usuario usuario;
    private VistaTablero vistaTablero;
    private JPanel panelBarcos;
    private JButton switchOrientacion;
    private JLabel estadoOrientacion;
    private String orientacionSeleccionada = "H";
    private List<Barco> barcosPanel = new ArrayList<>();

    public VistaColocacion(Usuario usuario) {
        this.usuario = usuario;
        setTitle("Colocación de Barcos - " + usuario.getNombre());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // TABLERO
        vistaTablero = new VistaTablero(usuario.getTablero());
        vistaTablero.setBackground(new Color(200, 230, 240)); // fondo azul claro
        add(vistaTablero, BorderLayout.CENTER);

        // PANEL DE BARCOS
        panelBarcos = new JPanel();
        panelBarcos.setLayout(new FlowLayout(FlowLayout.CENTER, 30, 10));
        panelBarcos.setBackground(new Color(180, 220, 240));
        add(panelBarcos, BorderLayout.SOUTH);

        // Botón de orientación con imagen
        switchOrientacion = new JButton();
        switchOrientacion.setPreferredSize(new Dimension(60, 60));
        switchOrientacion.setToolTipText("Cambiar dirección de los barcos");

        // TODO: coloca la imagen de orientación aquí
        // switchOrientacion.setIcon(new ImageIcon("resources/imagen_orientacion.png"));

        switchOrientacion.setContentAreaFilled(false);
        switchOrientacion.setBorderPainted(false);
        switchOrientacion.setFocusPainted(false);

        // Estado de orientación
        estadoOrientacion = new JLabel("Horizontal", SwingConstants.CENTER);
        estadoOrientacion.setForeground(Color.DARK_GRAY);
        estadoOrientacion.setFont(new Font("Arial", Font.PLAIN, 12));

        JPanel panelOrientacion = new JPanel();
        panelOrientacion.setLayout(new BorderLayout());
        panelOrientacion.setOpaque(false);
        panelOrientacion.add(switchOrientacion, BorderLayout.CENTER);
        panelOrientacion.add(estadoOrientacion, BorderLayout.SOUTH);

        panelBarcos.add(panelOrientacion);

        // Crear barcos visualmente
        crearBarco("Portaaviones", 4);
        crearBarco("Buque", 3);
        crearBarco("Submarino", 2);
        crearBarco("Crucero", 1);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void crearBarco(String tipo, int cantidad) {
    JPanel panel = new JPanel();
    panel.setLayout(new BorderLayout());
    panel.setOpaque(false);

    JLabel imagenBarco = new JLabel();
    imagenBarco.setHorizontalAlignment(SwingConstants.CENTER);
    imagenBarco.setVerticalAlignment(SwingConstants.CENTER);
    imagenBarco.setPreferredSize(new Dimension(60, 60));

    // Selecciona la imagen según el tipo
    String rutaImagen = switch (tipo.toLowerCase()) {
        case "portaaviones" -> "resources/Portaaviones.png";
        case "crucer" -> "resources/Crucero.png";
        case "submarino" -> "resources/Submarino.png";
        case "Destructor" -> "resources/Destructor.png";
        default -> null;
    };

    if (rutaImagen != null) {
        imagenBarco.setIcon(new ImageIcon(rutaImagen));
    }

    JLabel texto = new JLabel(tipo + " x" + cantidad, SwingConstants.CENTER);
    texto.setForeground(Color.DARK_GRAY);
    texto.setFont(new Font("Arial", Font.BOLD, 12));

    panel.add(imagenBarco, BorderLayout.CENTER);
    panel.add(texto, BorderLayout.SOUTH);

    panelBarcos.add(panel);
    barcosPanel.add(new Barco(tipo, cantidad));
    }


    public VistaTablero getVistaTablero() {
        return vistaTablero;
    }

    public String getOrientacionSeleccionada() {
        return orientacionSeleccionada;
    }
    
    public void marcarBarcoColocado(Barco barco) {
    Component[] componentes = panelBarcos.getComponents();
    for (Component c : componentes) {
        if (c instanceof JPanel panel) {
            // Asumimos que el JLabel de texto está en BorderLayout.SOUTH
            Component[] hijos = panel.getComponents();
            for (Component hijo : hijos) {
                if (hijo instanceof JLabel label) {
                    if (label.getText().startsWith(barco.getTipo())) {
                        // Deshabilitar todo el panel del barco
                        panel.setEnabled(false);
                        panel.setVisible(false); // opcional, si quieres ocultarlo
                        break;
                    }
                }
            }
        }
    }
    }
}
