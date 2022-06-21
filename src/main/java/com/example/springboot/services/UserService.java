package com.example.springboot.services;

import com.example.springboot.entities.User;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    public User createUser(User user) {
        User saveUser = new User(
                user.getId(),
                user.getName(),
                user.getUsername()
        );
        return saveUser;
    }
}
