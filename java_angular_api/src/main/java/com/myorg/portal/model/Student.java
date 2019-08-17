/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myorg.portal.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author chiraran
 */

@Entity
@Table(name = "students")
public class Student implements Serializable {    

    private  @Id @GeneratedValue Long id;
    private String name;
    private String course;

    public Student() {
    }

    public Student(String name, String course) {
        this.name = name;
        this.course = course;
    }
    
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    @Override
    public String toString() {
        return "Student{" + "id=" + id + ", name=" + name + ", course=" + course + '}';
    }  
    
}
