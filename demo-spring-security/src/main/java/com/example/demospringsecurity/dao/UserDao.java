package com.example.demospringsecurity.dao;

import com.example.demospringsecurity.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserDao extends JpaRepository<User, Long>{

    User findByUsername(String username);
}