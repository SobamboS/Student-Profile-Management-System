package com.student.stuentprofile;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class StuentProfileApplication{

    public static void main(String[] args){

    ConfigurableApplicationContext context = SpringApplication.run(StuentProfileApplication.class, args);

    // Get the SwingUI bean from the application context
    SwingUI swingUI = context.getBean(SwingUI.class);

    // Display the Swing-based user interface
        swingUI.setVisible(true);
}
}