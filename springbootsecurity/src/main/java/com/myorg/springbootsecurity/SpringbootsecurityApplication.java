package com.myorg.springbootsecurity;

import com.myorg.springbootsecurity.controllers.AuthorityController;
import com.myorg.springbootsecurity.controllers.UserController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import sun.tools.jar.CommandLine;

@SpringBootApplication
public class SpringbootsecurityApplication implements CommandLineRunner{

    @Autowired
    AuthorityController authorityController;

    @Autowired
    UserController userController;

    public static void main(String[] args) {
        SpringApplication.run(SpringbootsecurityApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println(userController.getUserByUsername("nation"));
    }

}
