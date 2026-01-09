package Modelo;

import Controlador.ConexionBD;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.*;
import java.time.LocalDate;

public class AdminWindow extends JFrame {
    private JPanel panelAdmin;
    private JPanel Inicial;
    private JButton Op1;
    private JButton Op2;
    private JButton Op3;
    private JButton Salir;
    private JButton Op4;
    private JButton op5;
    private JButton op6;
    private JButton op7;
    private JPanel RegistrarSolicitante;
    private JButton limpiarButton;
    private JTextField inNuevoNombre;
    private JTextField inNuevoTipoLicencia;
    private JTextField inNuevaClave;
    private JTextField inNuevaCedula;
    private JButton guardarButton;
    private JPanel VerificarRequisitos;
    private JButton aprobarButton;
    private JCheckBox certificadoMedicoCheckBox;
    private JCheckBox pagoCheckBox;
    private JCheckBox multasCheckBox;
    private JTextField inIdUsuario;
    private JButton limpiarButton1;
    private JPanel RegistrarExamenes;
    private JButton guardarButton1;
    private JTextField inNotaTeorica;
    private JTextField inNotaPractica;
    private JTextField inIDRegistrarEx;
    private JPanel GestionDeTramites;
    private JComboBox comboBox1;
    private JTable table1;
    private JPanel GenerarLicencias;
    private JPanel GestionUsuarios;
    private JPanel ReportesEstadisticas;
    private JButton guardarButton2;
    private JTextField inIdGenerarLicencias;
    private JButton exportarButton;
    private JTable table2;
    private JTextField textField10;
    private JButton buscarButton;
    private JTextField textField11;
    private JTextField textField12;
    private JTextField textField13;
    private JTextField textField14;
    private JTextField textField15;
    private JTextField textField16;
    private JButton crearButton;
    private JButton activarButton;
    private JButton desactivarButton;
    private JComboBox comboBox2;
    private JLabel valPendientes;
    private JLabel valEnPrueba;
    private JLabel valAprobados;
    private JLabel valGeneradas;
    private JButton exportarButton1;
    private JTextField inUserName;
    private JTextField inNuevoRol;
    private JLabel labelEncontrado;
    private JLabel labelNombre;
    private JButton buscarButton1;
    private JButton buscarButton2;
    private JLabel labelEncontrado2;
    private JLabel labelNombre2;
    private JButton limpiarButton2;
    private JTabbedPane tabbedPane1;
    private JLabel modId;
    private JLabel modNombre;
    private JLabel modCedula;
    private JLabel modTipo;
    private JLabel modFecha;
    private JLabel modEstado;
    private JButton generarLicenciaButton;
    private JButton validarExamenButton;
    private JButton buscarButton3;
    private JLabel labelEncontrado3;
    private JLabel labelNombre3;
    private JScrollPane scrollPane;
    private JButton guardarButton3;
    private JButton limpiarButton3;
    private JTextField textField1;
    private JComboBox comboBox3;
    private JComboBox comboBox4;
    private JTextField textField2;
    private JButton buscarButton4;


    private String estadoUsuarioActual = null;
    private int idUsuarioActual = -1;


    public AdminWindow() {
        setTitle("Ventana Administrador");
        setContentPane(panelAdmin); // panel principal del form
        setSize(600, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);


        Inicial.setLayout(new CardLayout());

        Inicial.add(RegistrarSolicitante,"RegistrarSolicitante");
        Inicial.add(VerificarRequisitos,"VerificarRequisitos");
        Inicial.add(RegistrarExamenes,"RegistrarExamenes");
        Inicial.add(GestionDeTramites,"GestionDeTramites");
        Inicial.add(GenerarLicencias,"GenerarLicencias");
        Inicial.add(GestionUsuarios,"GestionUsuarios");
        Inicial.add(ReportesEstadisticas,"ReportesEstadisticas");



        Op1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarPanel("RegistrarSolicitante");
            }
        });
        Op2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarPanel( "VerificarRequisitos");
            }
        });
        Op3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarPanel( "RegistrarExamenes");
            }
        });
        Op4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarPanel("GestionDeTramites");
                cargarTabla();
            }
        });
        op5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarPanel("GenerarLicencias");
            }
        });
        op6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarPanel("GestionUsuarios");
                estadoInicialGestionUsuarios();
            }
        });
        op7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarPanel("ReportesEstadisticas");
                cargarEstadisticas();
            }
        });
        Salir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Login().setVisible(true);
                SwingUtilities.getWindowAncestor(Salir).dispose();
            }
        });

        guardarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    guardarUsuarioConLicencia(
                            inNuevaCedula.getText(),
                            inNuevoNombre.getText(),
                            inUserName.getText(),
                            inNuevaClave.getText(),
                            inNuevoRol.getText(),
                            inNuevoTipoLicencia.getText()
                    );

                    JOptionPane.showMessageDialog(null, "✅ Usuario guardado correctamente");

                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null,
                            "❌ Error al guardar:\n" + ex.getMessage(),
                            "Error",
                            JOptionPane.ERROR_MESSAGE
                    );
                }

            }
        });
        limpiarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                inNuevoNombre.setText("");
                inNuevaClave.setText("");
                inNuevoRol.setText("");
                inNuevoRol.setText("");
                inNuevoTipoLicencia.setText("");
                inUserName.setText("");
                inNuevaCedula.setText("");
            }
        });
        buscarButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int id = Integer.parseInt(inIdUsuario.getText());
                    buscarUsuariosporID(id);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "ID inválido");
                }
            }
        });
        aprobarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                aprobarUsuarioActual();
            }
        });


        ItemListener listener = new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                evaluarHabilitacionAprobar();
            }
        };
        certificadoMedicoCheckBox.addItemListener(listener);
        pagoCheckBox.addItemListener(listener);
        multasCheckBox.addItemListener(listener);
        limpiarButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                inIdUsuario.setText("");
                labelEncontrado.setText("[-----------]");
                labelNombre.setText("[-----------]");
                certificadoMedicoCheckBox.setSelected(false);
                pagoCheckBox.setSelected(false);
                multasCheckBox.setSelected(false);
                aprobarButton.setEnabled(false);
                idUsuarioActual = -1;
                estadoUsuarioActual = null;
            }
        });
        buscarButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int id = Integer.parseInt(inIDRegistrarEx.getText());
                    buscarUsuariosporID2(id);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "ID inválido");
                }

            }
        });
        guardarButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                guardarCalificaciones();
            }
        });
        limpiarButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                inIDRegistrarEx.setText("");
                labelEncontrado2.setText("[-----------]");
                labelNombre2.setText("[-----------]");
                inNotaPractica.setText("");
                inNotaTeorica.setText("");
            }
        });
        table1.getSelectionModel().addListSelectionListener(e -> {

            if (e.getValueIsAdjusting()) return;

            int fila = table1.getSelectedRow();
            if (fila == -1) return;

            int idUsuario = (int) table1.getValueAt(fila, 0);

            cargarDetalleUsuario(idUsuario);
        });

        comboBox1.setModel(new DefaultComboBoxModel<>(new String[]{
                "Todos",
                "Pendiente",
                "En examenes",
                "Aprobado",
                "Rechazado"
        }));
        comboBox2.setModel(new DefaultComboBoxModel<>(new String[]{
                "Todos",
                "Pendiente",
                "En examenes",
                "Aprobado",
                "Rechazado"
        }));

        comboBox2.setSelectedIndex(0);
        comboBox3.setModel(new DefaultComboBoxModel<>(new String[]{
                "Hoy",
                "Últimos 7 días",
                "Último mes"
        }));

        comboBox3.setSelectedIndex(0);
        comboBox4.setModel(new DefaultComboBoxModel<>(new String[]{
                "Todos",
                "A",
                "B",
                "C",
                "D",
                "E"
        }));
        comboBox4.setSelectedIndex(0);

        comboBox1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cargarTabla();
            }
        });
        validarExamenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                mostrarPanel("RegistrarExamenes");

                inIDRegistrarEx.setText(modId.getText());

                try {
                    int id = Integer.parseInt(modId.getText());
                    buscarUsuariosporID2(id);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "ID inválido");
                }
            }
        });

        configurarTabla();
        cargarTabla();
        configurarTablaLicencia();


        generarLicenciaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                moverLicencia();
            }
        });
        buscarButton3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int id = Integer.parseInt(inIdGenerarLicencias.getText());
                    buscarUsuariosporID3(id);
                    cargarLicencia(id);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "ID inválido");
                }
            }
        });
        guardarButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                generarLicencia(idUsuarioActual);
            }
        });
        table2.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                validarAccionesLicencia();
            }
        });

        buscarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int id;
                try {
                    id = Integer.parseInt(textField10.getText());
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "ID inválido");
                    return;
                }

                String sql = """
                        SELECT u.*, l.tipo
                        FROM usuarios u
                        LEFT JOIN licencia l ON l.ID_usuario = u.ID
                        WHERE u.ID = ?
                        """;

                try (Connection conn = ConexionBD.getConnection();
                     PreparedStatement ps = conn.prepareStatement(sql)) {

                    ps.setInt(1, id);
                    ResultSet rs = ps.executeQuery();

                    if (rs.next()) {

                        textField11.setText(rs.getString("nombre"));
                        textField13.setText(rs.getString("cedula"));
                        textField14.setText(rs.getString("username"));
                        textField15.setText(rs.getString("clave"));
                        textField16.setText(rs.getString("rol"));
                        textField12.setText(rs.getString("estado"));
                        textField1.setText(rs.getString("tipo"));

                        habilitarCampos(false, true, true, true, true, true,true,false);

                        crearButton.setEnabled(false);
                        activarButton.setEnabled(true);
                        desactivarButton.setEnabled(true);

                    } else {
                        JOptionPane.showMessageDialog(null, "Usuario no encontrado");
                    }

                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }

            }
        });
        crearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textField10.setText("");
                textField10.setEnabled(false); // ID NO
                habilitarCampos(false, true, true, true, true, true,true,false);

                textField10.setText("");
                textField11.setText("");
                textField13.setText("");
                textField14.setText("");
                textField15.setText("");
                textField16.setText("");
                textField12.setText("");
                textField1.setText("");

                guardarButton3.setEnabled(true);
                activarButton.setEnabled(false);
                desactivarButton.setEnabled(false);


            }
        });
        guardarButton3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!validarCamposUsuario()){
                    return;
                }

                boolean esNuevo = textField10.getText().isEmpty();

                if (esNuevo) {
                    insertarUsuario();
                } else {
                    actualizarUsuario();
                }
            }
        });
        activarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cambiarEstadoUsuario("Activo");
            }
        });
        desactivarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cambiarEstadoUsuario("Inactivo");
            }
        });
        limpiarButton3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textField10.setText("");
                textField11.setText("");
                textField12.setText("");
                textField13.setText("");
                textField14.setText("");
                textField15.setText("");
                textField16.setText("");
                textField1.setText("");

                habilitarCampos(true, false,false,false,false,false,false,false);

                crearButton.setEnabled(true);
                activarButton.setEnabled(false);
                desactivarButton.setEnabled(false);
            }
        });
        buscarButton4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cargarEstadisticas();
            }
        });

        comboBox2.addActionListener(e -> cargarEstadisticas());
        comboBox3.addActionListener(e -> cargarEstadisticas());
        comboBox4.addActionListener(e -> cargarEstadisticas());

    }


    private void mostrarPanel(String nombre) {
        CardLayout cl = (CardLayout) Inicial.getLayout();
        cl.show(Inicial, nombre);
    }
    private static void  guardarUsuarioConLicencia(
        String cedula,
        String nombre,
        String username,
        String clave,
        String rol,
        String tipoLicencia
    )throws SQLException{
        String sqlUsuario = "INSERT INTO usuarios (cedula, nombre, username, clave,rol) values (?,?,?,?,?)";
        String sqlLicencia = "INSERT INTO licencia (tipo, ID_usuario) values (?,?)";
        String sqlSolicitud = "INSERT INTO solicitud (feha, id_usuario) values (NOW(),?)";

        Connection conn = null;

        try{
            conn = ConexionBD.getConnection();
            conn.setAutoCommit(false);

            PreparedStatement psUsuario = conn.prepareStatement(
                    sqlUsuario,
                    Statement.RETURN_GENERATED_KEYS
            );

            psUsuario.setString(1,cedula);
            psUsuario.setString(2,nombre);
            psUsuario.setString(3,username);
            psUsuario.setString(4,clave);
            psUsuario.setString(5,rol);

            psUsuario.executeUpdate();

            ResultSet rs = psUsuario.getGeneratedKeys();
            if (!rs.next()) {
                throw new SQLException("No se pudo obtener el ID del usuario");
            }

            int idUsuario = rs.getInt(1);



            PreparedStatement psLicencia = conn.prepareStatement(sqlLicencia);
            psLicencia.setString(1, tipoLicencia);
            psLicencia.setInt(2, idUsuario);
            psLicencia.executeUpdate();

            PreparedStatement psSolicitud = conn.prepareStatement(sqlSolicitud);
            psSolicitud.setInt(1,idUsuario);
            psSolicitud.executeUpdate();

            conn.commit();
        }catch (SQLException e) {
            if (conn != null) conn.rollback();
            throw e;

        } finally {
            if (conn != null) {
                conn.setAutoCommit(true);
                conn.close();
            }
        }
    }
    private void buscarUsuariosporID(int idUsuario){
        String sql = "select nombre,estado from usuarios where ID = ?";
        try (Connection conn = ConexionBD.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)){

            ps.setInt(1, idUsuario);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                labelNombre.setText("["+rs.getString("nombre")+"]");
                labelEncontrado.setText("[Encontrado]");

                estadoUsuarioActual = rs.getString("estado");
                idUsuarioActual = idUsuario;

                aprobarButton.setEnabled(!"En examenes".equals(estadoUsuarioActual));
            }else {
                labelEncontrado.setText("[No encontrado]");
                aprobarButton.setEnabled(false);
                estadoUsuarioActual = null;
                idUsuarioActual = -1;
            }
            evaluarHabilitacionAprobar();
        }catch (SQLException e){
            JOptionPane.showMessageDialog(this, e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
        }
    }
    private void aprobarUsuarioActual() {

        if (idUsuarioActual == -1) {
            JOptionPane.showMessageDialog(this, "Primero busque un usuario");
            return;
        }

        if ("En examenes".equals(estadoUsuarioActual)) {
            JOptionPane.showMessageDialog(this, "El usuario ya está en exámenes");
            return;
        }

        String sql = "UPDATE usuarios SET estado = ? WHERE ID = ?";

        try (Connection conn = ConexionBD.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, "En examenes");
            ps.setInt(2, idUsuarioActual);
            ps.executeUpdate();

            estadoUsuarioActual = "En examenes";
            aprobarButton.setEnabled(false);

            JOptionPane.showMessageDialog(this, "✅ Usuario aprobado");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    private void evaluarHabilitacionAprobar() {

        boolean checksOk =
                certificadoMedicoCheckBox.isSelected() &&
                        pagoCheckBox.isSelected() &&
                        multasCheckBox.isSelected();

        boolean usuarioValido =
                idUsuarioActual != -1 &&
                        !"En examenes".equals(estadoUsuarioActual);

        aprobarButton.setEnabled(checksOk && usuarioValido);
    }
    private void guardarCalificaciones() {

        String teoricaTxt = inNotaTeorica.getText().trim();
        String practicaTxt = inNotaPractica.getText().trim();

        if (teoricaTxt.isEmpty() || practicaTxt.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Todos los campos son obligatorios");
            return;
        }

        double teorica, practica;

        try {
            teorica = Double.parseDouble(teoricaTxt);
            practica = Double.parseDouble(practicaTxt);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Las notas deben ser números");
            return;
        }

        if (teorica < 0 || practica < 0 || teorica > 10 || practica > 10) {
            JOptionPane.showMessageDialog(this, "Las notas deben estar entre 0 y 10");
            return;
        }

        double promedio = (teorica + practica) / 2;

        String nuevoEstado = (promedio >= 8) ? "Aprobado" : "Rechazado";

        String sql = """
        UPDATE usuarios
        SET estado = ?
        WHERE ID = ?
        """;

        try (Connection conn = ConexionBD.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, nuevoEstado);
            ps.setInt(2, idUsuarioActual);

            int filas = ps.executeUpdate();

            if (filas > 0) {
                JOptionPane.showMessageDialog(
                        this,
                        "Promedio: " + promedio + "\nEstado actualizado a: " + nuevoEstado
                );
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }
    private void buscarUsuariosporID2(int idUsuario){
        String sql = "select nombre,estado from usuarios where ID = ?";
        try (Connection conn = ConexionBD.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)){

            ps.setInt(1, idUsuario);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                labelNombre2.setText("["+rs.getString("nombre")+"]");
                labelEncontrado2.setText("[Encontrado]");

                estadoUsuarioActual = rs.getString("estado");
                idUsuarioActual = idUsuario;

                aprobarButton.setEnabled(!"En examenes".equals(estadoUsuarioActual));
            }else {
                labelEncontrado2.setText("[No encontrado]");
                aprobarButton.setEnabled(false);
                estadoUsuarioActual = null;
                idUsuarioActual = -1;
            }
            evaluarHabilitacionAprobar();
        }catch (SQLException e){
            JOptionPane.showMessageDialog(this, e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
        }
    }
    private void buscarUsuariosporID3(int idUsuario){

        String sql = "SELECT nombre, estado FROM usuarios WHERE ID = ?";

        try (Connection conn = ConexionBD.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, idUsuario);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                labelNombre3.setText("[" + rs.getString("nombre") + "]");
                labelEncontrado3.setText("[Encontrado]");

                estadoUsuarioActual = rs.getString("estado");
                idUsuarioActual = idUsuario;

            } else {

                labelNombre3.setText("[-----------]");
                labelEncontrado3.setText("[No encontrado]");
                estadoUsuarioActual = null;
                idUsuarioActual = -1;
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(
                    this,
                    e.getMessage(),
                    "Error",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }
    private void cargarTabla() {

        String estado = comboBox1.getSelectedItem().toString();

        String sql = """
        SELECT u.ID, u.nombre
        FROM usuarios u
        """;

        if (!estado.equals("Todos")) {
            sql += " WHERE u.estado = ?";
        }

        DefaultTableModel modelo = (DefaultTableModel) table1.getModel();
        modelo.setRowCount(0);

        try (Connection conn = ConexionBD.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            if (!estado.equals("Todos")) {
                ps.setString(1, estado);
            }

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                modelo.addRow(new Object[]{
                        rs.getInt("ID"),
                        rs.getString("nombre")
                });
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }

    private void cargarDetalleUsuario(int idUsuario) {

        String sql = """
        SELECT 
            u.ID,
            u.cedula,
            u.nombre,
            l.tipo,
            s.feha,
            u.estado
        FROM usuarios u
        JOIN licencia l ON l.ID_usuario = u.ID
        JOIN solicitud s ON s.id_usuario = u.ID
        WHERE u.ID = ?
        """;

        try (Connection conn = ConexionBD.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, idUsuario);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                modId.setText(rs.getString("ID"));
                modCedula.setText(rs.getString("cedula"));
                modNombre.setText(rs.getString("nombre"));
                modTipo.setText(rs.getString("tipo"));
                modFecha.setText(rs.getString("feha"));
                modEstado.setText(rs.getString("estado"));
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
        validarAcciones();
    }

    private void moverLicencia() {

        mostrarPanel("GenerarLicencias");

        inIdGenerarLicencias.setText(modId.getText());

        try {
            int id = Integer.parseInt(modId.getText());
            buscarUsuariosporID3(id);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "ID inválido");
        }
    }
    private void validarAcciones() {

        String estado = modEstado.getText();

        validarExamenButton.setEnabled("En examenes".equals(estado) || "Rechazado".equals(estado));
        generarLicenciaButton.setEnabled("Aprobado".equals(estado));
    }
    private void configurarTabla() {

        DefaultTableModel modelo = new DefaultTableModel(
                new Object[][]{},
                new String[]{"ID", "Nombre"}
        ) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        table1.setModel(modelo);

        table1.getColumnModel().getColumn(0).setMinWidth(0);
        table1.getColumnModel().getColumn(0).setMaxWidth(0);
        table1.getColumnModel().getColumn(0).setPreferredWidth(0);
    }
    private void cargarLicencia(int idUsuario) {

        String sql = """
        SELECT 
            l.ID_licencia AS num_licencia,
            l.fecha_emision,
            l.fecha_vencimiento,
            IFNULL(l.estado_licencia, 'No emitida') AS estado
        FROM licencia l
        WHERE l.ID_usuario = ?
        """;

        DefaultTableModel modelo = (DefaultTableModel) table2.getModel();
        modelo.setRowCount(0);

        try (Connection conn = ConexionBD.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, idUsuario);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                Object emision = rs.getDate("fecha_emision");
                Object vencimiento = rs.getDate("fecha_vencimiento");

                modelo.addRow(new Object[]{
                        rs.getInt("num_licencia"),
                        emision != null ? emision : "—",
                        vencimiento != null ? vencimiento : "—",
                        rs.getString("estado")
                });

            } else {
                JOptionPane.showMessageDialog(this,
                        "El usuario no tiene licencia registrada");
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }
    private void configurarTablaLicencia() {

        DefaultTableModel modelo = new DefaultTableModel(
                new Object[][]{},
                new String[]{"N° Licencia", "Emisión", "Vencimiento", "Estado"}
        ) {
            public boolean isCellEditable(int r, int c) {
                return false;
            }
        };

        table2.setModel(modelo);
    }
    private void generarLicencia(int idUsuario) {

        LocalDate emision = LocalDate.now();
        LocalDate vencimiento = emision.plusYears(5);

        String sql = """
        UPDATE licencia
        SET fecha_emision = ?, 
            fecha_vencimiento = ?, 
            estado_licencia = 'Emitida'
        WHERE ID_usuario = ?
        """;

        try (Connection conn = ConexionBD.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setDate(1, Date.valueOf(emision));
            ps.setDate(2, Date.valueOf(vencimiento));
            ps.setInt(3, idUsuario);

            ps.executeUpdate();

            JOptionPane.showMessageDialog(this, "✅ Licencia emitida");

            cargarLicencia(idUsuario);

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }
    private void validarAccionesLicencia() {

        int fila = table2.getSelectedRow();
        if (fila == -1) {
            exportarButton.setEnabled(false);
            return;
        }

        String estado = table2.getValueAt(fila, 3).toString();

        exportarButton.setEnabled("Emitida".equalsIgnoreCase(estado));
    }

    private void habilitarCampos(
            boolean id,
            boolean nombre,
            boolean cedula,
            boolean username,
            boolean clave,
            boolean rol,
            boolean tipo,
            boolean estado
    ) {
        textField10.setEnabled(id);
        textField11.setEnabled(nombre);
        textField13.setEnabled(cedula);
        textField14.setEnabled(username);
        textField15.setEnabled(clave);
        textField16.setEnabled(rol);
        textField12.setEnabled(estado);
        textField1.setEnabled(tipo);
    }
    private void estadoInicialGestionUsuarios() {

        habilitarCampos(true, false, false, false, false, false,false,false);

        textField10.setText("");
        textField11.setText("");
        textField12.setText("");
        textField13.setText("");
        textField14.setText("");
        textField15.setText("");
        textField16.setText("");
        textField1.setText("");

        crearButton.setEnabled(true);
        activarButton.setEnabled(false);
        desactivarButton.setEnabled(false);
    }
    private void insertarUsuario() {

        String nombre = textField11.getText().trim();
        String cedula = textField13.getText().trim();
        String username = textField14.getText().trim();
        String clave = textField15.getText().trim();
        String tipoLicencia = textField1.getText().trim();


        if (nombre.isEmpty() || cedula.isEmpty() || username.isEmpty() || clave.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Todos los campos son obligatorios");
            return;
        }

        String sqlUsuario = """
        INSERT INTO usuarios (nombre, cedula, username, clave)
        VALUES (?, ?, ?, ?)
        """;

        String sqlLicencia = "INSERT INTO licencia (tipo, ID_usuario) VALUES (?, ?)";
        String sqlSolicitud = "INSERT INTO solicitud (feha, id_usuario) VALUES (NOW(), ?)";

        Connection conn = null;

        try {
            conn = ConexionBD.getConnection();
            conn.setAutoCommit(false);


            PreparedStatement psUsuario = conn.prepareStatement(
                    sqlUsuario,
                    Statement.RETURN_GENERATED_KEYS
            );

            psUsuario.setString(1, nombre);
            psUsuario.setString(2, cedula);
            psUsuario.setString(3, username);
            psUsuario.setString(4, clave);
            psUsuario.executeUpdate();

            ResultSet rs = psUsuario.getGeneratedKeys();
            if (!rs.next()) {
                throw new SQLException("No se pudo obtener el ID del usuario");
            }

            int idUsuario = rs.getInt(1);

            PreparedStatement psLicencia = conn.prepareStatement(sqlLicencia);
            psLicencia.setString(1, tipoLicencia);
            psLicencia.setInt(2, idUsuario);
            psLicencia.executeUpdate();

            PreparedStatement psSolicitud = conn.prepareStatement(sqlSolicitud);
            psSolicitud.setInt(1, idUsuario);
            psSolicitud.executeUpdate();

            conn.commit();

            JOptionPane.showMessageDialog(this, "✅ Usuario creado correctamente");
            estadoInicialGestionUsuarios();

        } catch (SQLException e) {
            try {
                if (conn != null) conn.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            JOptionPane.showMessageDialog(this, e.getMessage());

        } finally {
            try {
                if (conn != null) {
                    conn.setAutoCommit(true);
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    private void actualizarUsuario() {

        String nombre = textField11.getText().trim();
        String cedula = textField13.getText().trim();
        String username = textField14.getText().trim();
        String clave = textField15.getText().trim();
        String rol = textField16.getText().trim();
        String tipoLicencia = textField1.getText().trim(); // CAMPO LICENCIA
        int idUsuario;

        try {
            idUsuario = Integer.parseInt(textField10.getText().trim());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "ID inválido");
            return;
        }


        if (nombre.isEmpty() || cedula.isEmpty() || username.isEmpty() || clave.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Todos los campos son obligatorios");
            return;
        }

        String sqlUsuario = """
        UPDATE usuarios
        SET nombre=?, cedula=?, username=?, clave=?, rol=?
        WHERE ID=?
        """;

        String sqlLicencia = """
        UPDATE licencia
        SET tipo=?
        WHERE ID_usuario=?
        """;

        Connection conn = null;

        try {
            conn = ConexionBD.getConnection();
            conn.setAutoCommit(false); // 🔐 TRANSACCIÓN

            // 1️⃣ UPDATE USUARIO
            PreparedStatement psUsuario = conn.prepareStatement(sqlUsuario);
            psUsuario.setString(1, nombre);
            psUsuario.setString(2, cedula);
            psUsuario.setString(3, username);
            psUsuario.setString(4, clave);
            psUsuario.setString(5, rol);
            psUsuario.setInt(6, idUsuario);
            psUsuario.executeUpdate();

            // 2️⃣ UPDATE LICENCIA
            PreparedStatement psLicencia = conn.prepareStatement(sqlLicencia);
            psLicencia.setString(1, tipoLicencia);
            psLicencia.setInt(2, idUsuario);
            psLicencia.executeUpdate();

            conn.commit(); // ✅ TODO OK

            JOptionPane.showMessageDialog(this, "✅ Usuario y licencia actualizados");

        } catch (SQLException e) {
            try {
                if (conn != null) conn.rollback(); // ⛔ DESHACE TODO
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            JOptionPane.showMessageDialog(this, e.getMessage());

        } finally {
            try {
                if (conn != null) {
                    conn.setAutoCommit(true);
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    private void cambiarEstadoUsuario(String actividad) {

        String sql = "UPDATE usuarios SET activiad=? WHERE ID=?";

        try (Connection conn = ConexionBD.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, actividad);
            ps.setInt(2, Integer.parseInt(textField10.getText()));

            ps.executeUpdate();

            JOptionPane.showMessageDialog(this, "Estado cambiado a " + actividad);

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }
    private boolean validarCamposUsuario() {

        if (textField11.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "El nombre es obligatorio");
            textField11.requestFocus();
            return false;
        }
        if (textField13.getText().length() != 10) {
            JOptionPane.showMessageDialog(this, "La cédula debe tener 10 caracteres");
            textField13.requestFocus();
            return false;
        }

        if (textField15.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "La clave es obligatoria");
            textField15.requestFocus();
            return false;
        }

        if (textField14.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "El username es obligatorio");
            textField14.requestFocus();
            return false;
        }
        if (textField1.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "El tipo de licencia es obligatorio");
            textField1.requestFocus();
            return false;
        }


        return true;
    }
    private String construirWhere(
            String estado
//            String tipoLicencia,
//            String cedula,
//            String rangoFecha
    ) {
        String where = " WHERE 1=1 ";

        if (!estado.equals("Todos")) {
            where += " AND u.estado = '" + estado + "' ";
        }

//        if (!tipoLicencia.trim().equalsIgnoreCase("Todos")) {
//            where += " AND l.tipo = '" + tipoLicencia + "' ";
//        }
//
//        if (!cedula.isEmpty()) {
//            where += " AND u.cedula = '" + cedula + "' ";
//        }
//
//        if (!rangoFecha.equals("Todos")) {
//            switch (rangoFecha) {
//                case "Hoy":
//                    where += " AND DATE(s.feha) = CURDATE() ";
//                    break;
//                case "Últimos 7 días":
//                    where += " AND s.feha >= DATE_SUB(CURDATE(), INTERVAL 7 DAY) ";
//                    break;
//                case "Último mes":
//                    where += " AND s.feha >= DATE_SUB(CURDATE(), INTERVAL 1 MONTH) ";
//                    break;
//            }
//        }

        return where;
    }

    private void cargarEstadisticas() {

        String rangoFecha = comboBox3.getSelectedItem().toString();
        String cedula = textField2.getText().trim();
        String tipoLicencia = comboBox4.getSelectedItem().toString().trim();

        String where = construirWhere("Todos");

        try (Connection conn = ConexionBD.getConnection()) {

            valPendientes.setText(String.valueOf(contar(conn, "Pendiente", where)));
            valEnPrueba.setText(String.valueOf(contar(conn, "En examenes", where)));
            valAprobados.setText(String.valueOf(contar(conn, "Aprobado", where)));
            valGeneradas.setText(String.valueOf(contarLicencias(conn, where)));

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }


    private int contar(Connection conn, String estado, String where) throws SQLException {

        String sql = """
        SELECT COUNT(*)
        FROM usuarios u
        LEFT JOIN licencia l ON l.ID_usuario = u.ID
        LEFT JOIN solicitud s ON s.id_usuario = u.ID
    """ + where + " AND u.estado = ?";
        System.out.println(sql);
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, estado);

            ResultSet rs = ps.executeQuery();
            rs.next();
            return rs.getInt(1);
        }

    }

    private int contarLicencias(Connection conn, String where) throws SQLException {

        String sql = """
    SELECT COUNT(*)
    FROM licencia l
    JOIN usuarios u ON u.ID = l.ID_usuario
    JOIN solicitud s ON s.id_usuario = u.ID
    """ + where + " AND l.estado_licencia = 'Emitida'";

        try (PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            rs.next();
            return rs.getInt(1);
        }
    }

}
