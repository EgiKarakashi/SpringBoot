package com.example.springboot_demo.entities;

import javax.persistence.*;
import java.time.LocalDateTime;


@Entity
@Table(name = "Spid")
public class Spid extends Base {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @OneToOne
    @JoinColumn(name = "userId")
    private User userId;
    private Status status;
    private Type type;

    public Spid() {

    }

    public User getUserId() {
        return userId;
    }

    public void setUser(User user) {
        this.userId = userId;
    }

    public Spid(LocalDateTime createdAt, String createdBy, User userId, long id, Status status, Type type) {
        super(createdAt, createdBy);
        this.id = id;
        this.status = status;
        this.type = type;
        this.userId = userId;
    }






    public User getId() {
        return userId;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Status getStatus() {
        return status;
    }

    public void setId(long id) {
        this.id = id;
    }
}
