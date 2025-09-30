package vista;

import modelo.Tablero;

import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.DataFlavor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class VistaTablero extends JPanel {
    private Tablero tablero;
    private Casilla[][] casillas;

    public interface DropListener {
        void onDrop(String tipo, int tamano, int fila, int col);
    }

    private DropListener dropListener;

    public VistaTablero(Tablero tablero) {
        this.tablero = tablero;
        int dimension = tablero.getDimension();

        setLayout(new GridLayout(dimension, dimension, 5, 5)); // espacio entre casillas
        setBackground(new Color(200, 230, 240)); // fondo azul claro general

        casillas = new Casilla[dimension][dimension];

        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                final int fila = i;
                final int col = j;

                Casilla casilla = new Casilla();
                casilla.setTransferHandler(new TransferHandler("text") {
                    @Override
                    public boolean canImport(TransferSupport support) {
                        return support.isDataFlavorSupported(DataFlavor.stringFlavor);
                    }

                    @Override
                    public boolean importData(TransferSupport support) {
                        if (!canImport(support)) return false;

                        try {
                            String data = (String) support.getTransferable().getTransferData(DataFlavor.stringFlavor);
                            String[] partes = data.split(":");
                            String tipo = partes[0];
                            int tamano = Integer.parseInt(partes[1]);

                            if (dropListener != null) {
                                dropListener.onDrop(tipo, tamano, fila, col);
                            }

                            return true;
                        } catch (Exception e) {
                            e.printStackTrace();
                            return false;
                        }
                    }
                });

                // Efecto hover
                casilla.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseEntered(MouseEvent e) {
                        casilla.setHover(true);
                    }

                    @Override
                    public void mouseExited(MouseEvent e) {
                        casilla.setHover(false);
                    }
                });

                casillas[i][j] = casilla;
                add(casilla);
            }
        }
    }

    public void setDropListener(DropListener listener) {
        this.dropListener = listener;
    }

    public void actualizar() {
        char[][] celdas = tablero.getCeldas();
        for (int i = 0; i < celdas.length; i++) {
            for (int j = 0; j < celdas[i].length; j++) {
                // Si quieres mostrar barcos: casillas[i][j].setColorSegun(celdas[i][j]);
                casillas[i][j].repaint(); // siempre repintar para mantener la estética
            }
        }
    }

    public Casilla getCasilla(int fila, int col) {
        return casillas[fila][col];
    }

    public Tablero getTablero() {
        return tablero;
    }

    // Clase interna de casilla con esquinas redondeadas y hover
    public static class Casilla extends JPanel {
        private boolean hover = false;

        public Casilla() {
            setPreferredSize(new Dimension(50, 50));
            setOpaque(false); // elimina fondo rectangular por defecto
        }

        public void setHover(boolean hover) {
            this.hover = hover;
            repaint();
        }

        @Override
        protected void paintComponent(Graphics g) {
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            // Color base azul oscuro suave
            Color baseColor = new Color(120, 180, 220);
            if (hover) {
                baseColor = baseColor.brighter();
            }

            g2.setColor(baseColor);
            g2.fillRoundRect(0, 0, getWidth(), getHeight(), 20, 20);

            g2.dispose();
        }
    }
}
