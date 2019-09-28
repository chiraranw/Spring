/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myorg.springbootsecurity.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 *
 * @author chiraran
 * @Date Sep 28, 2019
 */
public class AppUserDetails implements UserDetails {

    private final String userName;
    private final String password;
    private final List<GrantedAuthority> authorities;

    public AppUserDetails(User user) {
        this.userName = user.getUsername();
        this.password = user.getPassword();
        List<GrantedAuthority> authos = new ArrayList<>();
        user.getAuthorities().forEach((autho) -> {
            authos.add(new SimpleGrantedAuthority(autho.getRole()));
        });

        this.authorities = authos;

    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return userName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

}
