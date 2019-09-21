/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myorg.springjpaonetomany.services;

import com.myorg.springjpaonetomany.model.Authority;
import com.myorg.springjpaonetomany.respositories.AuthorityRepository;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author chiraran
 */
@Service
public class AuthorityService {

    @Autowired
    AuthorityRepository authorityRepository;

    public List<Authority> getAuthoritiesByUsername(String username) {
        return authorityRepository.getAuthorityByUserName(username);
    }

    public Set<String> getRolesByUserName(String username) {
        return authorityRepository.getRolesByUserName(username);
    }

}
