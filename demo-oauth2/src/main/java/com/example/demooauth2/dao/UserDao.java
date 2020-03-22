package com.example.demooauth2.dao;

import com.example.demooauth2.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User, Long> {

    User findByUsername(String username);
}