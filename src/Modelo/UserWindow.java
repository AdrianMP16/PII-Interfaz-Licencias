package Modelo;

import Controlador.ConexionBD;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserWindow extends JFrame {
    private JButton regresarButton;
    private JLabel nombreUser;
    private JLabel cedulaUser;
    private JLabel estadoUser;
    private JLabel licenciaUser;
    private JPanel panelUser;
    private JLabel lblNombre;
    private JLabel lblCedula;
    private JLabel lblProceso;
    private JLabel idUser;
    private JLabel estadoLicenciaUser;

    private int idUsuario;

    public UserWindow(int idUsuario){

        this.idUsuario=idUsuario;


        setTitle("Ventana Usuario");
        setContentPane(panelUser);
        setSize(600,400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        cargarDatosUsuario();
        regresarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Login().setVisible(true);
                SwingUtilities.getWindowAncestor(regresarButton).dispose();
            }
        });
    }
    private void cargarDatosUsuario() {

        String sql = """
        SELECT u.nombre, u.cedula, u.username, u.estado, u.ID, l.tipo,l.estado_licencia
        FROM usuarios u
        INNER JOIN licencia l ON u.ID = l.ID_usuario
        WHERE u.ID = ?
        """;

        try (Connection conn = ConexionBD.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, idUsuario);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                nombreUser.setText(rs.getString("nombre"));
                cedulaUser.setText(rs.getString("cedula"));
                estadoUser.setText(rs.getString("estado"));
                licenciaUser.setText(rs.getString("tipo"));
                idUser.setText(rs.getString("ID"));
                estadoLicenciaUser.setText(rs.getString("estado_licencia"));

            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }

}
