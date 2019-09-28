/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myorg.springbootsecurity.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author chiraran
 * @Date Sep 27, 2019
 */
@Controller
public class AppController {

    @GetMapping("/home")
    public String home() {
        return "home";
    }

    @GetMapping("/admin")
    public String admin() {
        return "admin/admin";
    }

    @GetMapping("/managers")
    public String managers() {
        return "managers/managers";
    }

    @GetMapping("/public")
    public String public_() {
        return "public/public";
    }

    @GetMapping("/users")
    public String users() {
        return "users/users";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

}
