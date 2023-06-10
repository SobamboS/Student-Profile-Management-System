package com.student.stuentprofile;

import org.springframework.stereotype.Component;

import javax.swing.*;
@Component
public class SwingUI extends JFrame{

    public SwingUI( ){
        // Set up the frame
        setTitle("Swing UI");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400,300);

        // Create a panel to hold the components
        JPanel panel=new JPanel();

        // Create a button and add it to the panel
        JButton button=new JButton("Click Me");
        panel.add(button);

        // Add the panel to the frame
        getContentPane().add(panel);
    }
}