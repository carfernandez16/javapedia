package com.contactos.form;

import com.contactos.controller.ContactosController;
import com.contactos.model.Contacto;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by cfernandez
 * on 5/17/17.
 */
public class ContactosForm {

    private JPanel panel;
    private JTextField nombreTextField;
    private JTextField edadTextField;
    private JTextField correoTextField;
    private JTextField telefonoTextField;
    private JTextArea notasTextArea;
    private JTextField codeTextField;
    private JCheckBox checkBoxFamiliar;
    private ButtonGroup grupoRadioButtons;
    private JRadioButton radioHombre;
    private JRadioButton radioMujer;
    private JComboBox ciudadesComboBox;
    private JButton guardarButton;
    private JButton cargarButton;
    private JButton limpiarButton;
    private JButton exportarButton;

    public void init() {
        JFrame frame = new JFrame("Registro Contacto");
        frame.setSize(320, 450);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel = new JPanel();
        frame.add(panel);
        drawComponents(panel);
        frame.setVisible(true);
    }

    private void drawComponents(JPanel panel) {
        panel.setLayout(null);
        drawName();
        drawEdad();
        drawGenero();
        drawCorreo();
        drawCiudad();
        drawTelefono();
        drawCodigp();
        drawFamiliar();
        drawNotas();
        drawBotones();
    }

    public void drawName(){
        // Nombre
        JLabel nombreLabel = new JLabel("Nombre");
        nombreLabel.setBounds(20,20,80,25);
        panel.add(nombreLabel);

        nombreTextField = new JTextField(20);
        nombreTextField.setBounds(100,20,180,25);
        panel.add(nombreTextField);
    }

    public void drawEdad(){
        // Edad
        JLabel edadLabel = new JLabel("Edad");
        edadLabel.setBounds(20,50,80,25);
        panel.add(edadLabel);

        edadTextField = new JTextField(20);
        edadTextField.setBounds(100,50,180,25);
        panel.add(edadTextField);
    }

    public void drawGenero(){
        // Genero
        JLabel generoLabel = new JLabel("Genero");
        generoLabel.setBounds(20,80,80,25);
        panel.add(generoLabel);

        radioHombre = new JRadioButton("Hombre");
        radioHombre.setBounds(100,80,100,25);
        radioHombre.setSelected(true);
        panel.add(radioHombre);
        radioMujer = new JRadioButton("Mujer");
        radioMujer.setBounds(200,80,100,25);
        panel.add(radioMujer);

        grupoRadioButtons = new ButtonGroup();
        grupoRadioButtons.add(radioHombre);
        grupoRadioButtons.add(radioMujer);

    }

    public void drawCorreo(){
        // Correo
        JLabel correoLabel = new JLabel("Correo");
        correoLabel.setBounds(20,110,80,25);
        panel.add(correoLabel);

        correoTextField = new JTextField(20);
        correoTextField.setBounds(100,110,180,25);
        panel.add(correoTextField);
    }

    public void drawCiudad(){
        // Ciudad
        JLabel ciudadLabel = new JLabel("Ciudad");
        ciudadLabel.setBounds(20,140,80,25);
        panel.add(ciudadLabel);

        String ciudades[] = {"La Paz", "Cochabamba", "Santa Cruz", "Oruro",
                "Beni", "Pando", "Chuquisaca", "Tarija", "Potosi"};
        ciudadesComboBox = new JComboBox(ciudades);
        ciudadesComboBox.setBounds(100, 140, 180, 25);
        panel.add(ciudadesComboBox);
    }

    public void drawTelefono(){
        // Usuario
        JLabel telefonoLabel = new JLabel("Telefono");
        telefonoLabel.setBounds(20,170,80,25);
        panel.add(telefonoLabel);

        telefonoTextField = new JTextField(20);
        telefonoTextField.setBounds(100,170,180,25);
        panel.add(telefonoTextField);
    }

    public void drawCodigp(){
        // Password
        JLabel passwordLabel = new JLabel("Codigo *");
        passwordLabel.setBounds(20,200,80,25);
        panel.add(passwordLabel);

        codeTextField = new JTextField(20);
        codeTextField.setBounds(100,200,180,25);
        panel.add(codeTextField);
    }

    public void drawFamiliar(){
        // familiar
        JLabel familiarLabel = new JLabel("Familiar");
        familiarLabel.setBounds(20,230,80,25);
        panel.add(familiarLabel);

        checkBoxFamiliar = new JCheckBox("");
        checkBoxFamiliar.setBounds(100, 230, 50, 25);
        panel.add(checkBoxFamiliar);
    }

    public void drawNotas(){
        // notas
        notasTextArea = new JTextArea("Notas");
        notasTextArea.setBounds(20, 270, 265, 100);
        panel.add(notasTextArea);
    }

    public void drawBotones(){
        // Boton
        guardarButton = new JButton("Guardar");
        guardarButton.setBounds(10, 380, 80, 25);
        panel.add(guardarButton);
        adicionarBotonGuardarAction();

        cargarButton = new JButton("Cargar");
        cargarButton.setBounds(80, 380, 80, 25);
        panel.add(cargarButton);
        adicionarBotonCargarAction();

        limpiarButton = new JButton("Limpiar");
        limpiarButton.setBounds(150, 380, 80, 25);
        panel.add(limpiarButton);
        adicionarBotonLimpiarAction();

        exportarButton = new JButton("Exportar");
        exportarButton.setBounds(220, 380, 80, 25);
        panel.add(exportarButton);
        adicionarBotonExportarAction();
    }

    private void adicionarBotonExportarAction() {
        ContactosController contactosController = new ContactosController();
        exportarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Exportando todos los datos a excel....");
                String rutaArchivoExcel = "/Users/cfernandez/Desktop/docencia/contactosApp/contactos.xlsx";
                JOptionPane.showMessageDialog(null, rutaArchivoExcel, "ContactosApp" ,1);
                contactosController.exportarAExcel(rutaArchivoExcel);
            }
        });
    }

    private void adicionarBotonLimpiarAction() {
        limpiarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Limpiando formulario....");
                nombreTextField.setText("");
                edadTextField.setText("");
                correoTextField.setText("");
                ciudadesComboBox.setSelectedIndex(0);
                telefonoTextField.setText("");
                codeTextField.setText("");
                radioHombre.setSelected(true);
                checkBoxFamiliar.setSelected(false);
                notasTextArea.setText("");
            }
        });
    }

    private void adicionarBotonCargarAction() {
        ContactosController contactosController = new ContactosController();
        cargarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String codigo = codeTextField.getText();
                if (codigo.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Debe introducir el codigo del contacto", "ContactosApp", 2);
                    return;
                }

                System.out.println("Cargando contacto con codigo: " + codigo);
                Contacto contacto = contactosController.cargar(codigo);
                if (contacto != null) {
                    System.out.println("No existe contacto con codigo: " + codigo);

                    nombreTextField.setText(contacto.getNombre());
                    edadTextField.setText(String.valueOf(contacto.getEdad()));
                    correoTextField.setText(contacto.getCorreo());
                    ciudadesComboBox.setSelectedIndex(contacto.getCiudad());
                    telefonoTextField.setText(contacto.getTelefono());
                    codeTextField.setText(contacto.getCodigo());

                    if ("Hombre".equals(contacto.getGenero())) {
                        radioHombre.setSelected(true);
                    } else {
                        radioMujer.setSelected(true);
                    }

                    checkBoxFamiliar.setSelected(contacto.isFamiliar());
                    notasTextArea.setText(contacto.getNotas());
                }
            }
        });
    }

    public void adicionarBotonGuardarAction(){
        ContactosController contactosController = new ContactosController();

        guardarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = nombreTextField.getText();
                String edad = edadTextField.getText();
                String genero = getGenero();
                String correo = correoTextField.getText();
                int ciudad = ciudadesComboBox.getSelectedIndex();
                String usuario = telefonoTextField.getText();
                String codigo = codeTextField.getText();
                boolean esFamiliar = checkBoxFamiliar.isSelected();
                String notas = notasTextArea.getText();

                int edad0 = Integer.parseInt(edad);
                Contacto contacto = new Contacto(nombre, edad0, genero, correo, usuario, codigo,
                        esFamiliar, notas, ciudad);
                contactosController.guardar(contacto);
            }

            public String getGenero() {
                String genero = radioHombre.getText();
                if(radioMujer.isSelected()){
                    genero = radioMujer.getText();
                }
                return genero;
            }
        });
    }


}
