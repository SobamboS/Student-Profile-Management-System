package com.student.stuentprofile.service;

import com.student.stuentprofile.exception.StudentException;
import com.student.stuentprofile.model.Student;
import com.student.stuentprofile.service.dto.RegistrationRequest;
import org.springframework.stereotype.Service;

@Service
public interface StudentService{
        Student register(RegistrationRequest request )throws StudentException;
        String login (Student student);

        Student getStudent(Long id);
        Student updateStudent(Long id, Student student);
        boolean deleteStudent(Long id);

    }

