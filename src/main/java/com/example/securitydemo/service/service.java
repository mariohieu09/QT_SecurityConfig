package com.example.securitydemo.service;

import com.example.securitydemo.model.user;
import com.example.securitydemo.repository.repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class service {

    @Autowired
    private repository repository;

    public void save(user u){
        repository.save(u);
    }
}
