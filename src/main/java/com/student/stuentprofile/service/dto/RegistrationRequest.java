package com.student.stuentprofile.service.dto;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class RegistrationRequest{

    @NotBlank(message="Field cannot be blank")
    @Size(max=20)
    private String name;

    @NotBlank(message="Field cannot be blank")
    private String matricNumber;

    @NotBlank(message="Field cannot be blank")
    private String department;

    @Email(message="Please input a valid email")
    @NotBlank(message="Field cannot be blank")
    private String email;


    @NotBlank(message="Field cannot be blank")
    @Pattern(regexp="^([a-zA-Z\\d@*#$&!]{5,15})$")
    private String password;
}

