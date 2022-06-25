package com.example.springboot_demo.controller;

import com.example.springboot_demo.entities.Spid;
import com.example.springboot_demo.entities.Status;
import com.example.springboot_demo.entities.Type;
import com.example.springboot_demo.entities.User;
import com.example.springboot_demo.repository.SpidRepository;
import com.example.springboot_demo.repository.UserRepository;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;


class MainControllerTest {

    UserRepository userRepository;
    SpidRepository spidRepository;

    @Test
    void createUser() {
        User user = new User();
        user.setName("test");
        user.setEmail("test@test.com");
        userRepository.save(user);
        Assertions.assertThat(user.getId()).isNotNull();
    }

    @Test
    void updateUser() {
        User user = userRepository.findById(1L).get();
        user.setName("test2");
        userRepository.save(user);
        Assertions.assertThat(user.getName()).isEqualTo("test2");
    }

    @Test
    void getAllSpids() {
        Iterable<Spid> spids = spidRepository.findAll();
        Assertions.assertThat(spids).isNotNull();
    }

    @Test
    void getSpid() {
        User spid = userRepository.findById(1L).get();
    }

    @Test
    void createSpid() {
        User user = userRepository.findById(1L).get();
        Spid spid = new Spid(LocalDateTime.now(), "test", user, 1, Status.APPROVED, Type.LEVEL_1);
        spidRepository.save(spid);
        Assertions.assertThat(spid.getId()).isNotNull();
    }

    @Test
    void changeSpidStatus() {
        Spid spid = spidRepository.findById(1L).get();
        spid.setStatus(Status.PENDING);
        spidRepository.save(spid);
        Assertions.assertThat(spid.getStatus()).isEqualTo(Status.PENDING);
    }

    @Test
    void deleteSpid() {
        Spid spid = spidRepository.findById(1L).get();
        spidRepository.delete(spid);
        Optional<Spid> spidOptional = spidRepository.findById(1L);
        Assertions.assertThat(spidOptional.isPresent()).isFalse();
    }
}
