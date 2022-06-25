package com.example.springboot_demo.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "users")
public class User extends Base {
    @Id
    private long id;
    private String name;
    private String surname;
    private String cardNo;
    private String username;
    private String password;
    private String email;

    public User(long id, LocalDateTime createdAt, String createdBy, String name, String surname, String cardNo, String username, String password, String email) {
        super(createdAt, createdBy);
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.cardNo = cardNo;
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public User() {
        super();
    }

    public String getUsername() {
        return username;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getCardNo() {
        return cardNo;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }
}
