package com.example;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by PanMin on 2017/5/10.
 */
public interface UserDB extends JpaRepository<User,Integer> {
    List<User> findByAge(int age);
}
