package com.myorg.demo;

import com.myorg.demo.controllers.AuthorityController;
import com.myorg.demo.controllers.UserController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringbootjpaOneToManyApplication implements CommandLineRunner {
    
    public static void main(String[] args) {
        SpringApplication.run(SpringbootjpaOneToManyApplication.class, args);
    }
    
    @Autowired
    AuthorityController authorityController;
    
    @Autowired
    UserController userController;
    
    @Override
    public void run(String... args) throws Exception {
        authorityController.getAuthoritiesByUserName("nation").stream().forEach(a -> System.out.println(a));
        System.out.println(userController.getUserByUsername("nation"));
    }
    
}
