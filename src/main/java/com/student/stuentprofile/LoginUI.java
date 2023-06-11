package com.student.stuentprofile;

import javax.swing.*;
import java.awt.*;


public class LoginUI extends JFrame{
        private final JTextField usernameField;
        private final JPasswordField passwordField;
        private JButton loginButton;

        public LoginUI() {
            setTitle("Login");
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setSize(300, 150);
            setLocationRelativeTo(null);

            JPanel panel = new JPanel();
            panel.setLayout(new GridLayout(3, 2));

            JLabel emailLabel = new JLabel("Email:");
            usernameField = new JTextField();

            JLabel passwordLabel = new JLabel("Password:");
            passwordField = new JPasswordField();

            loginButton = new JButton("Login");
            loginButton.addActionListener(e -> {
                String email = usernameField.getText();
                String password = new String(passwordField.getPassword());
            });

            panel.add(emailLabel);
            panel.add(usernameField);
            panel.add(passwordLabel);
            panel.add(passwordField);
            panel.add(new JLabel());
            panel.add(loginButton);

            add(panel);
        }

        public static void main(String[] args) {
            SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                    LoginUI loginUI = new LoginUI();
                    loginUI.setVisible(true);
                }
            });
        }
    }
