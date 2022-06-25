package com.example.springboot_demo.service;

import com.example.springboot_demo.entities.User;
import com.example.springboot_demo.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {


    UserRepository userRepository;

    UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(User user) throws Exception {
        Optional<User> findIfUserExists = userRepository.findUserById(user.getId());

        if (findIfUserExists.isPresent()) {
            throw new Exception("User already exists");
        }
        return userRepository.save(user);
    }

    public User updateUser(User user, long id) throws Exception {
        if (userRepository.findUserById(id).isPresent()) {
            user.setId(id);
            return userRepository.save(user);
        } else {
            throw new Exception("User does not exists");
        }
    }
}
