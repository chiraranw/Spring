/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myorg.springbootsecurity.services;

import com.myorg.springbootsecurity.model.AppUserDetails;
import com.myorg.springbootsecurity.model.User;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 *
 * @author chiraran
 * @Date Sep 28, 2019
 */
@Service
public class AppUserDetailsService implements UserDetailsService {

    @Autowired
    UserService userService;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

        User user = userService.getUserByUsername(userName);
        System.out.println("User from.."+user);
        if (Objects.isNull(user)) {
            throw new UsernameNotFoundException("Could not file the user");//Informing an intruder?            
        }

        return new AppUserDetails(user);
    }

}
