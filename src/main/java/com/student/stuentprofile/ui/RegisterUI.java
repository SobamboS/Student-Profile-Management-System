package com.student.stuentprofile.ui;

import javax.swing.*;
import java.awt.*;


public class RegisterUI extends JFrame{

        private JTextField nameField;
        private JPasswordField passwordField;
        private JTextField departmentField;
        private JTextField emailField;
        private JTextField matricNumberField;
        private JButton registerButton;

        public RegisterUI() {
            setTitle("Registration");
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setSize(300, 250);
            setLocationRelativeTo(null);

            JPanel panel = new JPanel();
            panel.setLayout(new GridLayout(6, 2));

            JLabel nameLabel = new JLabel("Name:");
            nameField = new JTextField();

            JLabel passwordLabel = new JLabel("Password:");
            passwordField = new JPasswordField();

            JLabel departmentLabel = new JLabel("Department:");
            departmentField = new JTextField();

            JLabel emailLabel = new JLabel("Email:");
            emailField = new JTextField();

            JLabel matricNumberLabel = new JLabel("Matric Number:");
            matricNumberField = new JTextField();

            registerButton = new JButton("Register");
            registerButton.addActionListener(e -> {
                String username = nameField.getText();
                String password = new String(passwordField.getPassword());
                String department = departmentField.getText();
                String email = emailField.getText();
                String matricNumber = matricNumberField.getText();


                JOptionPane.showMessageDialog(RegisterUI.this, "Registration successful");
            });

            panel.add(nameLabel);
            panel.add(nameField);
            panel.add(passwordLabel);
            panel.add(passwordField);
            panel.add(departmentLabel);
            panel.add(departmentField);
            panel.add(emailLabel);
            panel.add(emailField);
            panel.add(matricNumberLabel);
            panel.add(matricNumberField);
            panel.add(new JLabel());
            panel.add(registerButton);

            add(panel);
        }

        public static void main(String[] args) {
            SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                    RegisterUI registerUI = new RegisterUI();
                    registerUI.setVisible(true);
                }
            });
        }
    }

