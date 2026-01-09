package Modelo;

import Controlador.ConexionBD;



import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Locale;


public class Login extends JFrame{
    private JPanel panel1;
    private JTextField InUser;
    private JButton salirButton;
    private JButton ingresarButton;
    private JPasswordField inPassword;
    private JLabel labelImagen;
    private JPanel IMG_panel;

    private int intentos = 0;

    public Login(){
        setTitle("Pantalla del Login");
        setSize(1000,500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setContentPane(panel1);
        setLocationRelativeTo(null);

        cargarImagen();

        ingresarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    String user = InUser.getText().trim();
                    String contra = inPassword.getText().trim();
                if (user.isEmpty() || contra.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Campos vacios");
                    return;
                }

                LoginResult resultado = validarLogin(user,contra);



                if (resultado == null){
                    intentos ++;
                    JOptionPane.showMessageDialog(null,"Usuario o clave incorrectas | Intentos: "+intentos);
                    InUser.setText("");
                    inPassword.setText("");

                    if (intentos >=3){
                        JOptionPane.showMessageDialog(null,"Intentos maximos alcanzados");
                        System.exit(0);
                    }
                    return;
                }

                dispose();

                switch (resultado.rol){
                    case "administrador":
                        new AdminWindow().setVisible(true);
                        break;
                    case "analista":
                        new AnalistaWindow().setVisible(true);
                        break;
                    default:
                        new UserWindow(resultado.idUsuario).setVisible(true);
                        break;
                }
            }
        });
        salirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }
    private LoginResult validarLogin(String usuario, String contrasena) {

        String sql = "SELECT ID, rol FROM usuarios WHERE username = ? AND clave = ?";

        try (Connection conn = ConexionBD.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, usuario);
            ps.setString(2, contrasena);

            try(ResultSet rs = ps.executeQuery()){
                if (rs.next()){
                    return new LoginResult(
                            rs.getInt("ID"),
                            rs.getString("rol").trim().toLowerCase()
                    );
                }
            }
        } catch (SQLException e) {
            System.out.println("Error del login: "+e.getMessage());;
        }
        return null;
    }

    private void cargarImagen(){
        ImageIcon icon = new ImageIcon(getClass().getResource("/imagenes/Imagen1.jpg")
        );

        Image imgEscalada = icon.getImage().getScaledInstance(
                500,
                500,
                Image.SCALE_SMOOTH
        );

        JLabel labelImagen = new JLabel(new ImageIcon(imgEscalada));
        labelImagen.setHorizontalAlignment(SwingConstants.CENTER);
        labelImagen.setVerticalAlignment(SwingConstants.CENTER);
        IMG_panel.setLayout(new BorderLayout());
        IMG_panel.add(labelImagen, BorderLayout.CENTER);
    }

}
