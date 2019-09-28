/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myorg.springbootsecurity.configurations;

import com.myorg.springbootsecurity.services.AppUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

/**
 *
 * @author chiraran
 * @Date Sep 27, 2019
 */
@EnableWebSecurity
@Order(Ordered.HIGHEST_PRECEDENCE)
@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    
    
    @Autowired
    AppUserDetailsService userDetailsService;

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {           
        auth.userDetailsService(userDetailsService);
        
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http//.csrf().disable()
                .authorizeRequests()
                .antMatchers("/login").permitAll()                
                .antMatchers("/managers").hasAnyAuthority("ADMIN","MANAGER")
                .antMatchers("/public").permitAll()
                .antMatchers("/users").hasAnyAuthority("ADMIN","USER")
                .antMatchers("/admin").hasAnyAuthority("ADMIN")
                .and()
                .formLogin().loginPage("/login")
                .defaultSuccessUrl("/home")
                .and()
                .logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout")).logoutSuccessUrl("/login");
    }

    @Bean
    public PasswordEncoder getPasswordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

}
