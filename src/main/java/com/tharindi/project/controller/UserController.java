package com.tharindi.project.controller;

import com.tharindi.project.models.User;
import com.tharindi.project.services.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/users")

public class UserController {

    private  UserRepository repository;
    @Autowired
    public UserController(UserRepository repository) {
        this.repository = repository;
    }

    @GetMapping({"","/"})
    public String showUserList(Model model){
        List<User> users= repository.findAll();
        model.addAttribute("users",users);
        return "index";
    }

}
