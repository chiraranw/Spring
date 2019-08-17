/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myorg.portal.controller;

import com.myorg.portal.model.Student;
import com.myorg.portal.service.StudentRepository;
import com.myorg.portal.utils.StudentNotFoundException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author chiraran
 */
@RestController
public class StudentController {

    @Autowired
    StudentRepository studentRepo;

    //Add a new student to the DB - POST
    @PostMapping("/student")
    public Student add(@RequestBody Student student) {
        return studentRepo.save(student);
    }

    //Get all students in the DB
    @GetMapping("/students")
    public List<Student> getAll() {
        return studentRepo.findAll();
    }

    //Delete a student
    @DeleteMapping("/students/{id}")
    public void delete(@PathVariable Long id) {
        studentRepo.deleteById(id);
    }

    //Update a student
    @PutMapping("/students/{id}")
    public void update(@RequestBody Student newStudent, @PathVariable Long id) {
        newStudent.setId(id);
        studentRepo.save(newStudent);
    }

    //Get a student
    @GetMapping("/students/{id}")
    public Student getStudent(@PathVariable Long id){
        return studentRepo.findById(id).orElseThrow(()->new StudentNotFoundException(id));
    }
}
