/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myorg.portal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author chiraran
 */
@Controller
public class Test {
    @RequestMapping("/home")
    public String obj(){
        System.out.println("called controller");
        return "Nation";
    }
    
}
