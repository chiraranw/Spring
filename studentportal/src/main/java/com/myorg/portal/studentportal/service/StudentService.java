/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myorg.portal.studentportal.service;

import com.myorg.portal.studentportal.model.Student;
import com.myorg.portal.studentportal.repo.StudentRepo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author chiraran
 */
@Service
public class StudentService {

    @Autowired
    private StudentRepo studentRepo;

    public List<Student> getAll() {
        return studentRepo.findAll();
    }

    public void save(Student student) {
        studentRepo.save(student);
    }
    
    public Student get(int id){
        return studentRepo.getOne(id);
    }
    
    public void delete(int id){
        studentRepo.deleteById(id);
    }
}
