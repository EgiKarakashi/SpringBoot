package com.example.springboot_demo.controller;

import com.example.springboot_demo.entities.Spid;
import com.example.springboot_demo.entities.Status;
import com.example.springboot_demo.entities.Type;
import com.example.springboot_demo.entities.User;
import com.example.springboot_demo.repository.SpidRepository;
import com.example.springboot_demo.repository.UserRepository;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;


import java.util.Optional;


class MainControllerTest {

    UserRepository userRepository;
    SpidRepository spidRepository;

    @Test
    void createUserTest() {
        try {
            User user = new User();
            user.setName("test");
            user.setEmail("test@test.com");
            userRepository.save(user);
            Assertions.assertThat(user.getId()).isNotNull();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    void updateUserTest() {
        try {
            User user = userRepository.findById(1L).get();
            user.setName("test2");
            userRepository.save(user);
            Assertions.assertThat(user.getName()).isEqualTo("test2");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    void getAllSpidsTest() {
        try {
            Iterable<Spid> spids = spidRepository.findAll();
            Assertions.assertThat(spids).isNotNull();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    void getSpidTest() {
        try {
            Optional<Spid> spid = spidRepository.findById(1L);
            Assertions.assertThat(spid).isNotNull();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    void createSpidTest() {
        try {
            User user = userRepository.findById(1L).get();
            Spid spid = new Spid();
            spidRepository.save(spid);
            Assertions.assertThat(spid.getId()).isNotNull();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    void changeSpidStatusTest() {
        try {
            Spid spid = spidRepository.findById(1L).get();
            spid.setStatus(Status.PENDING);
            spidRepository.save(spid);
            Assertions.assertThat(spid.getStatus()).isEqualTo(Status.PENDING);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    void deleteSpidTest() {
        try {
            Spid spid = spidRepository.findById(1L).get();
            spidRepository.delete(spid);
            Assertions.assertThat(spidRepository.findById(1L)).isEmpty();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
