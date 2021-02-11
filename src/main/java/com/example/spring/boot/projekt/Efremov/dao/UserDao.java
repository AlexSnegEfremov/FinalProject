package com.example.spring.boot.projekt.Efremov.dao;

import com.example.spring.boot.projekt.Efremov.modal.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends JpaRepository<User, Long> {
    User findByEmail(String email);
}
