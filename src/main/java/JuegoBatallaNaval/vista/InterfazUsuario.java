package JuegoBatallaNaval.vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;

public class InterfazUsuario extends JFrame {
    private CardLayout cardLayout;
    private JPanel mainPanel;

    public InterfazUsuario() {
        setTitle("Batalla Naval");
        setSize(400, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);

        mainPanel.add(crearPanelInicio(), "Inicio");
        mainPanel.add(crearPanelRegistro(), "Registro");
        mainPanel.add(crearPanelLogin(), "Login");
        mainPanel.add(crearPanelPrincipal(), "Principal");

        add(mainPanel);
        cardLayout.show(mainPanel, "Inicio");
    }

    private JPanel crearPanelInicio() {
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBackground(new Color(70,120,150));
        GridBagConstraints gbc = new GridBagConstraints();

        JLabel titulo = new JLabel("Batalla Naval");
        titulo.setFont(new Font("Arial", Font.BOLD, 24));
        titulo.setForeground(Color.WHITE);

        JButton btnLogin = new JButton("Inicia Sesión");
        JButton btnRegistro = new JButton("Regístrese");

        btnLogin.addActionListener(e -> cardLayout.show(mainPanel, "Login"));
        btnRegistro.addActionListener(e -> cardLayout.show(mainPanel, "Registro"));

        gbc.gridx=0; gbc.gridy=0; gbc.insets=new Insets(20,0,20,0);
        panel.add(titulo, gbc);
        gbc.gridy=1; panel.add(btnLogin, gbc);
        gbc.gridy=2; panel.add(btnRegistro, gbc);

        return panel;
    }

    private JPanel crearPanelRegistro() {
        JPanel panel = new JPanel(new GridLayout(5,1,10,10));
        panel.setBackground(new Color(150,200,230));

        JTextField txtNombre = new JTextField();
        JTextField txtCorreo = new JTextField();
        JPasswordField txtPass = new JPasswordField();
        JButton btnRegistrar = new JButton("Registrar");

        btnRegistrar.addActionListener(e -> {
            try (FileWriter fw = new FileWriter("usuarios.txt", true)) {
                fw.write(txtNombre.getText() + ";" +
                         txtCorreo.getText() + ";" +
                         new String(txtPass.getPassword()) + "\n");
                JOptionPane.showMessageDialog(this, "Usuario registrado!");
                cardLayout.show(mainPanel, "Inicio");
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });

        panel.add(new JLabel("Nombre"));
        panel.add(txtNombre);
        panel.add(new JLabel("Correo"));
        panel.add(txtCorreo);
        panel.add(new JLabel("Contraseña"));
        panel.add(txtPass);
        panel.add(btnRegistrar);

        return panel;
    }

    private JPanel crearPanelLogin() {
        JPanel panel = new JPanel(new GridLayout(4,1,10,10));
        panel.setBackground(new Color(150,200,230));

        JTextField txtCorreo = new JTextField();
        JPasswordField txtPass = new JPasswordField();
        JButton btnEntrar = new JButton("Entrar");

        btnEntrar.addActionListener(e -> {
            if (validarLogin(txtCorreo.getText(), new String(txtPass.getPassword()))) {
                JOptionPane.showMessageDialog(this, "Bienvenido!");
                cardLayout.show(mainPanel, "Principal");
            } else {
                JOptionPane.showMessageDialog(this, "Datos incorrectos.");
            }
        });

        panel.add(new JLabel("Correo"));
        panel.add(txtCorreo);
        panel.add(new JLabel("Contraseña"));
        panel.add(txtPass);
        panel.add(btnEntrar);

        return panel;
    }

    private JPanel crearPanelPrincipal() {
        JPanel panel = new JPanel(new GridLayout(3,1,10,10));
        panel.setBackground(new Color(200,230,250));

        JButton btnJugar = new JButton("Jugar");
        JButton btnLeaderboard = new JButton("Leaderboard");
        JButton btnCerrar = new JButton("Cerrar Sesión");

        btnCerrar.addActionListener(e -> cardLayout.show(mainPanel, "Inicio"));

        panel.add(btnJugar);
        panel.add(btnLeaderboard);
        panel.add(btnCerrar);

        return panel;
    }

    private boolean validarLogin(String correo, String pass) {
        try (Scanner sc = new Scanner(new File("usuarios.txt"))) {
            while (sc.hasNextLine()) {
                String[] data = sc.nextLine().split(";");
                if (data[1].equals(correo) && data[2].equals(pass)) return true;
            }
        } catch (IOException e) { e.printStackTrace(); }
        return false;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new InterfazUsuario().setVisible(true));
    }
}
