package Modelo;

import javax.swing.*;

public class AnalistaWindow extends JFrame{
    private JButton Op1;
    private JPanel Inicial;
    private JPanel RegistrarSolicitante;
    private JButton Op2;
    private JButton Op3;
    private JButton Salir;
    private JButton Op4;
    private JButton guardarButton;
    private JButton limpiarButton;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JButton aprobarButton;
    private JButton limpiarButton1;
    private JCheckBox certificadoMedicoCheckBox;
    private JCheckBox pagoCheckBox;
    private JCheckBox multasCheckBox;
    private JButton guardarButton1;
    private JTextField textField5;
    private JTextField textField6;
    private JComboBox comboBox1;
    private JTabbedPane tabbedPane1;
    private JTable table1;
    private JTextField textField7;
    private JTextField textField8;
    private JPanel VerificarRequisitos;
    private JPanel RegistrarExamenes;
    private JPanel GestionDeTramites;
    private JPanel GenerarLicencias;
    private JButton guardarButton2;
    private JButton exportarButton;
    private JTextField textField9;
    private JTable table2;
    private JPanel panelAnalista;
    private JButton op5;
    private JButton op6;
    private JPanel GestionUsuarios;
    private JButton op7;
    private JButton guardarButton3;
    private JButton actualizarButton;
    private JTextField textField10;
    private JButton buscarButton;
    private JTextField textField11;
    private JTextField textField12;
    private JTextField textField13;
    private JTextField textField14;
    private JTextField textField15;
    private JTextField textField16;
    private JButton activarButton;
    private JButton desactivarButton;
    private JPanel ReportesEstadisticas;
    private JComboBox comboBox2;
    private JButton exportarButton1;
    private JLabel valPendientes;
    private JLabel valEnPrueba;
    private JLabel valAprobados;
    private JLabel valGeneradas;
    private JPanel panelAdmin;

    public AnalistaWindow() {
        setTitle("Ventana Analista");
        setContentPane(panelAnalista);
        setSize(600, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
