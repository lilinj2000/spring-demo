package com.example.demojwt.dao;

import com.example.demojwt.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User, Long> {

    User findByUsername(String username);
}