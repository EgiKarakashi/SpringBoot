package com.example.springboot_demo.repository;

import com.example.springboot_demo.entities.Spid;
import com.example.springboot_demo.entities.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface SpidRepository extends CrudRepository<Spid, Long> {
    List<Spid> findSpidById(User user);
}
