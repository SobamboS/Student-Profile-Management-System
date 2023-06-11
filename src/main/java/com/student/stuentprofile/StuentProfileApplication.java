package com.student.stuentprofile;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class StuentProfileApplication{

    public static void main(String[] args){

    ConfigurableApplicationContext context = SpringApplication.run(StuentProfileApplication.class, args);
    LoginUI loginUI = context.getBean(LoginUI.class);
    loginUI.setVisible(true);
        RegisterUI registerUI = context.getBean(RegisterUI.class);
        registerUI.setVisible(true);

}
}