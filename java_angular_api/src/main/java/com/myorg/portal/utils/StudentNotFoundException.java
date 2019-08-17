/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myorg.portal.utils;

/**
 *
 * @author chiraran
 */
public class StudentNotFoundException  extends RuntimeException{

    public StudentNotFoundException(Long id) {
        super("Could not find student with id: "+id);
        
    }
    
}
