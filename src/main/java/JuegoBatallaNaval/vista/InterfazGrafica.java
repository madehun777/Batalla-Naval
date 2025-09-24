package JuegoBatallaNaval.vista;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

public class InterfazGrafica extends JFrame {
    private final int dimension;
    private final JButton[][] botones;

    private final ImageIcon iconoAgua;
    private final ImageIcon iconoBarco;

    public InterfazGrafica(int dimension) {
        this.dimension = dimension;
        this.botones = new JButton[dimension][dimension];

        // Cargar íconos
        iconoAgua = new ImageIcon(getClass().getResource("/agua.png"));
        iconoBarco = new ImageIcon(getClass().getResource("/barco.png"));

        setTitle("Batalla Naval - Tablero");
        setSize(600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel panelTablero = new JPanel(new GridLayout(dimension, dimension));
        inicializarBotones(panelTablero);

        add(panelTablero, BorderLayout.CENTER);
    }

    private void inicializarBotones(JPanel panelTablero) {
        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                JButton boton = new JButton();
                configurarBoton(boton, iconoAgua);

                boton.addMouseListener(new HoverEfecto(boton));
                botones[i][j] = boton;
                panelTablero.add(boton);
            }
        }
    }

    private void configurarBoton(JButton boton, ImageIcon icono) {
        boton.setMargin(new Insets(0, 0, 0, 0));
        boton.setContentAreaFilled(false);
        boton.setBorderPainted(false);
        boton.setFocusPainted(false);

        boton.setIcon(escalarIcono(icono, 600 / dimension, 600 / dimension));
        boton.setName(icono.equals(iconoBarco) ? "barco" : "agua");
    }

    private ImageIcon escalarIcono(ImageIcon icono, int ancho, int alto) {
        Image img = icono.getImage().getScaledInstance(ancho, alto, Image.SCALE_SMOOTH);
        return new ImageIcon(img);
    }

    private ImageIcon oscurecerIcono(ImageIcon icono, int ancho, int alto) {
        Image img = icono.getImage();
        BufferedImage buffered = new BufferedImage(ancho, alto, BufferedImage.TYPE_INT_ARGB);

        Graphics2D g2d = buffered.createGraphics();
        g2d.drawImage(img, 0, 0, ancho, alto, null);

        g2d.setColor(new Color(0, 0, 0, 80)); // efecto tenue
        g2d.fillRect(0, 0, ancho, alto);

        g2d.dispose();
        return new ImageIcon(buffered);
    }

    public void actualizarCelda(int fila, int columna, boolean hayBarco) {
        configurarBoton(botones[fila][columna], hayBarco ? iconoBarco : iconoAgua);
    }

    // Clase interna para manejar el hover
    private class HoverEfecto extends MouseAdapter {
        private final JButton boton;

        public HoverEfecto(JButton boton) {
            this.boton = boton;
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            boton.setIcon(oscurecerIcono((ImageIcon) boton.getIcon(), boton.getWidth(), boton.getHeight()));
        }

        @Override
        public void mouseExited(MouseEvent e) {
            if ("barco".equals(boton.getName())) {
                configurarBoton(boton, iconoBarco);
            } else {
                configurarBoton(boton, iconoAgua);
            }
        }
    }
}

