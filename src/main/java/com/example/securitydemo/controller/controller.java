package com.example.securitydemo.controller;

import com.example.securitydemo.model.user;
import com.example.securitydemo.service.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;

@Controller
public class controller {
//    @GetMapping("/")
//    public ModelAndView index() {
//        return new ModelAndView("/index");
//    }

    @Autowired
    private service sv;

    @GetMapping("/user")
    public ModelAndView user(Principal principal) {
        // Get authenticated username from Principal
        System.out.println(principal.getName());
        return new ModelAndView("/user");
    }

    @GetMapping("/admin")
    public ModelAndView admin() {
        // Get authenticated username from SecurityContext
        SecurityContext context = SecurityContextHolder.getContext();
        System.out.println(context.getAuthentication().getName());
        return new ModelAndView("/admin");
    }

    @PostMapping("/user")
    public String createUser(@ModelAttribute("user") user u){
        sv.save(u);
        return "redirect:/user";
    }
}
