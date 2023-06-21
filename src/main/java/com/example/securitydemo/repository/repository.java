package com.example.securitydemo.repository;

import com.example.securitydemo.model.user;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface repository extends JpaRepository<user, Long> {

    Optional<user> findByUsername(String username);
}
