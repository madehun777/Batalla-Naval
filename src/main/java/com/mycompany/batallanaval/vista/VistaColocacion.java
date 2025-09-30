package vista;

import modelo.Usuario;
import modelo.Barco;

import javax.swing.*;
import java.awt.*;

public class VistaColocacion extends JFrame {

    private Usuario usuario;
    private VistaTablero vistaTablero;
    private JPanel panelBarcos;
    private JLabel orientacionLabel;

    public VistaColocacion(Usuario usuario) {
        this.usuario = usuario;

        setTitle("ColocaciÃ³n de Barcos - " + usuario.getNombre());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // TABLERO
        vistaTablero = new VistaTablero(usuario.getTablero());
        vistaTablero.setBackground(new Color(200, 230, 240));
        vistaTablero.setBorder(null);
        add(vistaTablero, BorderLayout.CENTER);

        // PANEL DE BARCOS
        panelBarcos = new JPanel(new FlowLayout(FlowLayout.CENTER, 40, 15));
        panelBarcos.setBackground(new Color(180, 220, 240));
        add(panelBarcos, BorderLayout.SOUTH);

        // Panel orientaciÃ³n
        JPanel panelOrientacion = new JPanel(new BorderLayout());
        panelOrientacion.setOpaque(false);

        JPanel contenedorIcono = new JPanel(new GridBagLayout());
        contenedorIcono.setOpaque(false);
        contenedorIcono.setPreferredSize(new Dimension(80, 80));

        ImagenEscaladaLabel iconoSwitch = new ImagenEscaladaLabel("/Switch.png");
        iconoSwitch.setPreferredSize(new Dimension(50, 50));
        contenedorIcono.add(iconoSwitch);

        orientacionLabel = new JLabel("Horizontal", SwingConstants.CENTER);
        orientacionLabel.setForeground(Color.DARK_GRAY);
        orientacionLabel.setFont(new Font("Arial", Font.BOLD, 12));

        panelOrientacion.add(contenedorIcono, BorderLayout.CENTER);
        panelOrientacion.add(orientacionLabel, BorderLayout.SOUTH);
        panelBarcos.add(panelOrientacion);

        // Crear barcos visualmente
        crearBarco("Portaaviones", 4, "/Portaaviones.png");
        crearBarco("Destructor", 3, "/Destructor.png");
        crearBarco("Submarino", 2, "/Submarino.png");
        crearBarco("Crucero", 1, "/Crucero.png");

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void crearBarco(String tipo, int cantidad, String rutaImagen) {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setOpaque(false);

        JLabel imagenBarco = new ImagenEscaladaLabel(rutaImagen);
        imagenBarco.setPreferredSize(new Dimension(80, 80));

        JLabel texto = new JLabel(tipo + " x" + cantidad, SwingConstants.CENTER);
        texto.setForeground(Color.DARK_GRAY);
        texto.setFont(new Font("Arial", Font.BOLD, 12));

        panel.add(imagenBarco, BorderLayout.CENTER);
        panel.add(texto, BorderLayout.SOUTH);

        panelBarcos.add(panel);
    }

    public VistaTablero getVistaTablero() {
        return vistaTablero;
    }

    public String getOrientacionSeleccionada() {
        return usuario.getOrientacion();
    }

    public void marcarBarcoColocado(Barco barco) {
        for (Component c : panelBarcos.getComponents()) {
            if (c instanceof JPanel panel) {
                for (Component hijo : panel.getComponents()) {
                    if (hijo instanceof JLabel label) {
                        if (label.getText().startsWith(barco.getTipo())) {
                            panel.setEnabled(false);
                            panel.setVisible(false);
                            break;
                        }
                    }
                }
            }
        }
    }

    // JLabel personalizado para escalar imÃ¡genes automÃ¡ticamente
    static class ImagenEscaladaLabel extends JLabel {
        private Image imagen;

        public ImagenEscaladaLabel(String ruta) {
            try {
                java.net.URL url = getClass().getResource(ruta);
                if (url != null) {
                    this.imagen = new ImageIcon(url).getImage();
                } else {
                    System.err.println("No se encontrÃ³ la imagen: " + ruta);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            setHorizontalAlignment(SwingConstants.CENTER);
            setVerticalAlignment(SwingConstants.CENTER);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            if (imagen != null) {
                g.drawImage(imagen, 0, 0, getWidth(), getHeight(), this);
            }
        }
    }
}
