package com.student.stuentprofile.service;

import com.student.stuentprofile.exception.StudentException;
import com.student.stuentprofile.model.Student;
import com.student.stuentprofile.repository.StudentRepository;
import com.student.stuentprofile.service.dto.RegistrationRequest;
import lombok.extern.slf4j.Slf4j;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

@Slf4j
public class StudentServiceImplementation implements StudentService{

        private  final StudentRepository studentRepository;


        @Autowired
        public StudentServiceImplementation(StudentRepository studentRepository){
            this.studentRepository=studentRepository;
        }


        @Override
        public Student register(RegistrationRequest request)throws StudentException{
            if(findByEmailIgnoreCase(request.getEmail())
                    .isPresent())
                throw new StudentException(String.format("%s is already used", request.getEmail()));
            Student student1 = new Student(
                    request.getName(),
                    request.getMatricNumber(),
                    request.getDepartment(),
                    request.getEmail(),
                    hashPassword(request.getPassword()));
            return  studentRepository.save(student1);
        }

        private String hashPassword (String password){
            return BCrypt.hashpw(password, BCrypt.gensalt());
        }

        private Optional<Student> findByEmailIgnoreCase(String email) {
            return studentRepository.findByEmailIgnoreCase(email);
        }

        @Override
        public String login (Student student)throws StudentException{
            var foundUser = studentRepository.findByEmailIgnoreCase(student.getEmail());
            if (foundUser.isEmpty()) throw new StudentException(String.format("%s is not registered", foundUser));
            if (!BCrypt.checkpw(student.getPassword(), foundUser.get().getPassword())) {
                throw new RuntimeException("Not found");
            }else return "Login Successful";
        }

        @Override
        public Student getStudent(Long id)throws StudentException{
            Student findStudent = studentRepository.findById(id).orElseThrow(()-> new StudentException("Student not found"));
            if(findStudent == null){
                throw new StudentException(String.format("%s not found",findStudent));
            }else {
                return findStudent;
            }
        }


        @Override
        public Student updateStudent(Long id, Student student)throws StudentException  {
            var existingStudent = studentRepository.findById(id)
                    .orElseThrow(()-> new StudentException("Student not found"));
            if (existingStudent != null) {
                existingStudent.setName(student.getName());
                existingStudent.setDepartment(student.getDepartment());
                existingStudent.setPassword(student.getPassword());
                existingStudent.setEmail(student.getEmail());
                return studentRepository.save(existingStudent);
            } else {
                return null;
            }
        }

        @Override
        public boolean deleteStudent(Long id) throws StudentException{
            Student existingStudent = studentRepository.findById(id).orElseThrow(()-> new StudentException("Student not found"));
            if (existingStudent != null) {
                studentRepository.delete(existingStudent);
                return true;
            } else {
                return false;
            }
        }
    }
