/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myorg.springbootsecurity.services;

import com.myorg.springbootsecurity.model.Authority;
import com.myorg.springbootsecurity.repositories.AuthorityRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author chiraran
 * @Date Sep 27, 2019
 */
@Service
public class AuthorityService {

    @Autowired
    AuthorityRepository authorityRepository;

    public List<Authority> getAuthoritiesByUserName(String username) {
        return authorityRepository.getAuthoritiesByUserName(username);
    }

}
