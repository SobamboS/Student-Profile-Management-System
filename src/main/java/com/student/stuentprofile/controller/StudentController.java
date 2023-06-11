package com.student.stuentprofile.controller;

import com.student.stuentprofile.model.Student;
import com.student.stuentprofile.service.StudentService;
import com.student.stuentprofile.service.dto.RegistrationRequest;
import com.student.stuentprofile.utils.ApiResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.ZonedDateTime;


@CrossOrigin
@RestController
@RequestMapping("/api/v1/student")
public class StudentController{
        @Autowired
        StudentService studentService;

//    public StudentController(StudentService studentService){
//        this.studentService=studentService;
//    }

    @PostMapping("/register/student")
        public ResponseEntity<?> registerStudent(@RequestBody @Valid RegistrationRequest request,
                                                 HttpServletRequest httpServletRequest){
            ApiResponse apiResponse = ApiResponse.builder()
                    .status(HttpStatus.OK.value())
                    .data(studentService.register(request))
                    .timeStamp(ZonedDateTime.now())
                    .path(httpServletRequest.getRequestURI())
                    .isSuccessful(true)
                    .build();
            return new ResponseEntity<>(apiResponse, HttpStatus.OK);
        }

        @PutMapping("/{id}/getStudent")
        public ResponseEntity<?> getStudent(@PathVariable @Valid Long id,
                                            HttpServletRequest httpServletRequest){
            ApiResponse apiResponse = ApiResponse.builder()
                    .status(HttpStatus.OK.value())
                    .data(studentService.getStudent(id))
                    .timeStamp(ZonedDateTime.now())
                    .path(httpServletRequest.getRequestURI())
                    .isSuccessful(true)
                    .build();
            return new ResponseEntity<>(apiResponse, HttpStatus.OK);
        }


        @PutMapping("/update")
        public ResponseEntity<?> updateStudent(@RequestBody @Valid Long id, Student student,
                                               HttpServletRequest httpServletRequest){
            ApiResponse apiResponse = ApiResponse.builder()
                    .status(HttpStatus.OK.value())
                    .data(studentService.updateStudent(id, student))
                    .timeStamp(ZonedDateTime.now())
                    .path(httpServletRequest.getRequestURI())
                    .isSuccessful(true)
                    .build();
            return new ResponseEntity<>(apiResponse, HttpStatus.OK);
        }

        @PutMapping("/login")
        public ResponseEntity<?> login(@RequestBody @Valid Student student,
                                       HttpServletRequest httpServletRequest){
            ApiResponse apiResponse = ApiResponse.builder()
                    .status(HttpStatus.OK.value())
                    .data(studentService.login(student))
                    .timeStamp(ZonedDateTime.now())
                    .path(httpServletRequest.getRequestURI())
                    .isSuccessful(true)
                    .build();
            return new ResponseEntity<>(apiResponse, HttpStatus.OK);
        }



        @DeleteMapping("/{id}/deleteStudent")
        public ResponseEntity<Void> deleteStudent(@PathVariable Long id) {
            boolean deleted = studentService.deleteStudent(id);
            if (deleted) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        }
    }

