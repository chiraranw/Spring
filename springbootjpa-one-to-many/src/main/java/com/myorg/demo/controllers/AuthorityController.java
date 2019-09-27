/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myorg.demo.controllers;

import com.myorg.demo.model.Authority;
import com.myorg.demo.services.AuthorityService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 *
 * @author chiraran
 * @Date Sep 27, 2019
 */
@Controller
public class AuthorityController {

    @Autowired
    AuthorityService authorityService;

    public List<Authority> getAuthoritiesByUserName(String username) {
        return authorityService.getAuthoritiesByUserName(username);
    }

}
