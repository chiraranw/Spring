/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myorg.springbootsecurity.services;

import com.myorg.springbootsecurity.model.User;
import com.myorg.springbootsecurity.repositories.UserRepository;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author chiraran
 * @Date Sep 27, 2019
 */
@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    AuthorityService authorityService;

    public User getUserByUsername(String usename) {
        User temp = userRepository.getUserByUsername(usename);
        if (!Objects.isNull(temp)) {
            temp.setAuthorities(authorityService.getAuthoritiesByUserName(usename));
        }

        return temp;
    }
}
