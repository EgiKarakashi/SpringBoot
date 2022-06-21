package com.example.springboot;

import com.example.springboot.entities.Spid;
import com.example.springboot.entities.Status;
import com.example.springboot.entities.User;
import com.example.springboot.services.SpidService;
import com.example.springboot.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application implements CommandLineRunner {

    @Autowired
    public UserService userService;

    @Autowired
    public SpidService spidService;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        User createdUser1 = userService.createUser(new User(1,"john","johndoe"));
        User createdUser2 = userService.createUser(new User(2, "jane", "janesmith"));
        User createdUser3 = userService.createUser(new User(3, "mike", "mikejones"));

        userService.editUser(createdUser1, 1, "john", "johndoe123");
        userService.editUser(createdUser2, 2, "jane", "janesmith123");
        userService.editUser(createdUser3, 3, "mike", "mikejones123");

        Spid createdSpid1 = spidService.createSpid(new Spid(1, createdUser1, Status.PENDING, "John Doe's SPID"));
        Spid createdSpid2 = spidService.createSpid(new Spid(2, createdUser1, Status.PENDING, "Jane Smith's SPID"));
        Spid createdSpid3 = spidService.createSpid(new Spid(3, createdUser1, Status.PENDING, "Mike Jones's SPID"));

        spidService.editSpid(createdSpid1, 1, createdUser1, Status.APPROVED, "John Doe's SPID");
        spidService.editSpid(createdSpid2, 2, createdUser2, Status.APPROVED, "Jane Smith's SPID");
        spidService.editSpid(createdSpid3, 3, createdUser3, Status.APPROVED, "Mike Jones's SPID");

        System.out.println("List of spids:\n");
        System.out.println("ID: " + createdSpid1.getId() + " Status: " + createdSpid1.getStatus() + " Description: " + createdSpid1.getDescription());
        System.out.println("ID: " + createdSpid2.getId() + " Status: " + createdSpid2.getStatus() + " Description: " + createdSpid2.getDescription());
        System.out.println("ID: " + createdSpid3.getId() + " Status: " + createdSpid3.getStatus() + " Description: " + createdSpid3.getDescription());

        System.out.println("\nList of spids connected to a user:\n");
        System.out.println("Username: " + createdUser1.getUsername() + " is connected to SPID: " + createdSpid1.getUser().getUsername().equals(createdUser1.getUsername()));
        System.out.println("Username: " + createdUser2.getUsername() + " is connected to SPID: " + createdSpid2.getUser().getUsername().equals(createdUser2.getUsername()));
        System.out.println("Username: " + createdUser3.getUsername() + " is connected to SPID: " + createdSpid3.getUser().getUsername().equals(createdUser3.getUsername()));
    }
}
