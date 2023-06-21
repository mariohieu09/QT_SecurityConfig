package com.example.securitydemo.security;

import com.example.securitydemo.model.user;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class authUser implements UserDetails {

    private user user;


    public authUser(user u) {
        this.user = u;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> list = new ArrayList<>();
        if(user.getRole().equals("user")){
            list.add(new SimpleGrantedAuthority("ROLE_USER"));
        }else{
            list.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
        }
        return list;
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return user.isStatus();
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return user.isStatus();
    }

}
