package com.mycompany.batallanaval.vista;
import com.mycompany.batallanaval.controlador.ControladorUsuario;
import com.mycompany.batallanaval.controlador.ControladorReporte;
import com.mycompany.batallanaval.modelo.Usuario;
import com.mycompany.batallanaval.modelo.Partida;
import com.mycompany.batallanaval.modelo.Reporte;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class InterfazGrafica extends JFrame {
    private ControladorUsuario controladorUsuario;
    private ControladorReporte controladorReporte;
    private JTextArea areaReportes;

    public InterfazGrafica() {
        controladorUsuario = new ControladorUsuario();
        controladorReporte = new ControladorReporte();

        setTitle("Batalla Naval");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        JPanel menuPanel = new JPanel();
        JButton btnRegistrar = new JButton("Registrar Usuario");
        JButton btnPartida = new JButton("Iniciar Partida");
        JButton btnReportes = new JButton("Ver Reportes");

        menuPanel.add(btnRegistrar);
        menuPanel.add(btnPartida);
        menuPanel.add(btnReportes);

        areaReportes = new JTextArea();
        areaReportes.setEditable(false);
        JScrollPane scroll = new JScrollPane(areaReportes);

        panel.add(menuPanel, BorderLayout.NORTH);
        panel.add(scroll, BorderLayout.CENTER);
        add(panel);

        // Listeners
        btnRegistrar.addActionListener(e -> registrarUsuario());
        btnPartida.addActionListener(e -> iniciarPartida());
        btnReportes.addActionListener(e -> mostrarReportes());
    }

    private void registrarUsuario() {
        String nombre = JOptionPane.showInputDialog(this, "Ingrese nombre del usuario:");
        if (nombre != null && !nombre.isBlank()) {
            controladorUsuario.crearUsuario(nombre);
            JOptionPane.showMessageDialog(this, "Usuario registrado con éxito.");
        }
    }

    private void iniciarPartida() {
        String j1 = JOptionPane.showInputDialog(this, "Nombre del jugador 1:");
        String j2 = JOptionPane.showInputDialog(this, "Nombre del jugador 2:");

        Usuario jugador1 = controladorUsuario.buscarUsuario(j1);
        Usuario jugador2 = controladorUsuario.buscarUsuario(j2);

        if (jugador1 == null || jugador2 == null) {
            JOptionPane.showMessageDialog(this, "Ambos jugadores deben estar registrados.");
            return;
        }

        Partida partida = new Partida(jugador1, jugador2);

        String ganadorNombre = JOptionPane.showInputDialog(this, "Nombre del ganador:");
        Usuario ganador = controladorUsuario.buscarUsuario(ganadorNombre);
        if (ganador == null) {
            JOptionPane.showMessageDialog(this, "El ganador debe estar registrado.");
            return;
        }

        Usuario perdedor = (ganador == jugador1) ? jugador2 : jugador1;
        partida.finalizarPartida(ganador, perdedor, 15);

        Reporte reporte = new Reporte(partida);
        controladorReporte.guardarReporte(reporte);

        JOptionPane.showMessageDialog(this, "Partida finalizada.\n" + reporte.generarResumen());
    }

    private void mostrarReportes() {
        StringBuilder sb = new StringBuilder();
        List<Reporte> lista = controladorReporte.getReportes();

        if (lista.isEmpty()) {
            areaReportes.setText("No hay reportes disponibles.");
            return;
        }

        for (Reporte r : lista) {
            sb.append(r.generarReporte()).append("\n------------------\n");
        }
        areaReportes.setText(sb.toString());
    }
}