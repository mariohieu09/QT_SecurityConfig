package com.example.securitydemo.security;

import com.example.securitydemo.model.user;
import com.example.securitydemo.repository.repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
public class authentication implements UserDetailsService {
    @Autowired
    private repository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
               Optional<user> optionalUser =  repository.findByUsername(username);
               if(optionalUser.isPresent()){
                   user u = optionalUser.get();
                       return new authUser(u);
               }else{
                   throw new UsernameNotFoundException("User not found");
               }
    }
}
