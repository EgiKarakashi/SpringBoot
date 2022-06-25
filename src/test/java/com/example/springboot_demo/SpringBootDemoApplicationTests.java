package com.example.springboot_demo;

import com.example.springboot_demo.entities.Spid;
import com.example.springboot_demo.entities.Status;
import com.example.springboot_demo.entities.Type;
import com.example.springboot_demo.entities.User;
import com.example.springboot_demo.service.SpidService;
import com.example.springboot_demo.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

@SpringBootTest(classes = {SpringBootDemoApplication.class})
class SpringBootDemoApplicationTests {

    @Autowired
    private UserService userService;

    @Autowired
    private SpidService spidService;

    @Test
    void test() {
        try {
            System.out.println(userService.(1));
            User user = userService.updateUserById(1, "john", "doe", "johndoe@gmail.com");
            System.out.println(userService.getUserById(1));

            Spid spid = spidService.createSpid(new Spid(LocalDateTime.now(), "johndoe", user, 1, Status.APPROVED, Type.LEVEL_1));
            System.out.println(spidService.findSpidById(user.getId()));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
