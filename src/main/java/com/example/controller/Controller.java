package com.example.controller;

import com.example.entity.User;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/index")
public class Controller {

    @Autowired
    private UserService userService;

    @GetMapping("/hi")
    public String index() {
        return "hello spring boot";
    }

    @RequestMapping("/users/{userId}")
    public User getUser(@PathVariable("userId") Integer userId) {

        System.out.println("userId : " + userId);

        User user = userService.getById(userId);
        System.out.println(user.toString());
        return user;
    }


}
