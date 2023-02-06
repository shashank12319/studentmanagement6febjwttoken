package com.wittybrains.studentmanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wittybrains.studentmanagement.model.Student;
import com.wittybrains.studentmanagement.model.Teacher;
import com.wittybrains.studentmanagement.repository.StudentRepository;
import com.wittybrains.studentmanagement.repository.TeacherRepository;

@RestController
@RequestMapping("/api/admin")
public class AdminController {
 
    @Autowired
    private StudentRepository studentRepository;
 
    @Autowired
    private TeacherRepository teacherRepository;
 
    @PostMapping("/student")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<Student> createStudent(@Validated @RequestBody Student student) {
        return ResponseEntity.ok(studentRepository.save(student));
    }
 
    @PostMapping("/teacher")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<Teacher> createTeacher(@Validated @RequestBody Teacher teacher) {
        return ResponseEntity.ok(teacherRepository.save(teacher));
    }
}
