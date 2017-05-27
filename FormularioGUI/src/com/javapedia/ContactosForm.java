package com.javapedia;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by cfernandez
 * on 5/14/17.
 */
public class ContactosForm {

    private JPanel panel;
    private JTextField nombreTextField;
    private JTextField edadTextField;
    private JTextField correoTextField;
    private JTextField usuarioTextField;
    private JTextArea notasTextArea;
    private JPasswordField passwordTextField;
    private JCheckBox checkBoxFamiliar;
    private JButton loginButton;
    private ButtonGroup grupoRadioButtons;
    private JRadioButton radioHombre;
    private JRadioButton radioMujer;
    private JComboBox ciudadesComboBox;

    public void init() {
        JFrame frame = new JFrame("Registro Contacto");
        frame.setSize(300, 450);
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
        drawUsuario();
        drawPassword();
        drawFamiliar();
        drawNotas();
        drawBotonGuardar();
    }

    public void drawName(){
        // Nombre
        JLabel nombreLabel = new JLabel("Nombre");
        nombreLabel.setBounds(20,20,80,25);
        panel.add(nombreLabel);

        nombreTextField = new JTextField(20);
        nombreTextField.setBounds(100,20,165,25);
        panel.add(nombreTextField);
    }

    public void drawEdad(){
        // Edad
        JLabel edadLabel = new JLabel("Edad");
        edadLabel.setBounds(20,50,80,25);
        panel.add(edadLabel);

        edadTextField = new JTextField(20);
        edadTextField.setBounds(100,50,165,25);
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

        ButtonGroup grupoRadioButtons=new ButtonGroup();
        grupoRadioButtons.add(radioHombre);
        grupoRadioButtons.add(radioMujer);

    }

    public void drawCorreo(){
        // Correo
        JLabel correoLabel = new JLabel("Correo");
        correoLabel.setBounds(20,110,80,25);
        panel.add(correoLabel);

        correoTextField = new JTextField(20);
        correoTextField.setBounds(100,110,165,25);
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
        ciudadesComboBox.setBounds(100, 140, 165, 25);
        panel.add(ciudadesComboBox);
    }

    public void drawUsuario(){
        // Usuario
        JLabel usuarioLabel = new JLabel("Usuario");
        usuarioLabel.setBounds(20,170,80,25);
        panel.add(usuarioLabel);

        usuarioTextField = new JTextField(20);
        usuarioTextField.setBounds(100,170,165,25);
        panel.add(usuarioTextField);
    }

    public void drawPassword(){
        // Password
        JLabel passwordLabel = new JLabel("Password");
        passwordLabel.setBounds(20,200,80,25);
        panel.add(passwordLabel);

        passwordTextField = new JPasswordField(20);
        passwordTextField.setBounds(100,200,165,25);
        panel.add(passwordTextField);
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
        notasTextArea.setBounds(20, 270, 250, 100);
        panel.add(notasTextArea);
    }

    public void drawBotonGuardar(){
        // Boton
        loginButton = new JButton("Guardar");
        loginButton.setBounds(100, 380, 80, 25);
        panel.add(loginButton);
        adicionarAction();
    }

    public void adicionarAction(){
        ContactosController contactosController = new ContactosController();

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = nombreTextField.getText();
                String edad = edadTextField.getText();
                String genero = getGenero();
                String correo = correoTextField.getText();
                int ciudad = ciudadesComboBox.getSelectedIndex();
                String usuario = usuarioTextField.getText();
                String password = String.valueOf(passwordTextField.getPassword());
                boolean esFamiliar = checkBoxFamiliar.isSelected();
                String notas = notasTextArea.getText();

                int edad0 = Integer.parseInt(edad);
                Contacto contacto = new Contacto(nombre, edad0, genero, correo, usuario, password,
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
