package com.student.stuentprofile.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

    @Entity
    @Table(name = "students")
    @Setter
    @Getter
    @AllArgsConstructor
    public class Student{

        @Id
        @GeneratedValue
        private Long id;

        @Column(name = "department")
        private String department;
        @Column(name="name")
        private String name;

        @Column(name="matricNumber")
        private String matricNumber;

        @Column(name="email")
        private String email;

        @Column(name="password")
        private String password;


    public Student(String name, String matricNumber, String department, String email, String password) {
        this.name = name;
        this.matricNumber = matricNumber;
        this.department = department;
        this.email = email;
        this.password=password;
    }

        public Student( ){
        }
    }


