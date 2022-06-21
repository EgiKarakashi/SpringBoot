package com.example.springboot;

import com.example.springboot.entities.User;
import com.example.springboot.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application implements CommandLineRunner {

    @Autowired
    public UserService userService;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        User createUser = userService.createUser(new User(1,"test","username"));
        System.out.println(createUser.getId()+ " " + createUser.getName()+ " " + createUser.getUsername());
    }
}
