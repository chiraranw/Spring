package com.myorg.springjpaonetomany;

import com.myorg.springjpaonetomany.services.AuthorityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringJpaOneToManyApplication implements CommandLineRunner {

    @Autowired
    AuthorityService authorityService;

    public static void main(String[] args) {
        SpringApplication.run(SpringJpaOneToManyApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("insdie run.............");
        authorityService.getAuthoritiesByUsername("javainuse").
                forEach(action -> System.out.println(action));

        System.out.println("insdie run.............");
        authorityService.getRolesByUserName("javainuse").
                forEach(action -> System.out.println(action));

    }

}
