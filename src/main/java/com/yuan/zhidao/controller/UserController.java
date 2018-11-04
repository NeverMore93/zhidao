package com.yuan.zhidao.controller;

import com.yuan.zhidao.entity.User;
import com.yuan.zhidao.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

@RestController
public class UserController {

    @Resource(name = "userService")
    private UserService userService;

    @PostMapping(value = "/user")
    @ResponseStatus(code=HttpStatus.CREATED )
    public User createUser(@RequestBody User user){
        userService.createUser(user);
        return (User)userService.loadUserByUsername(user.getUsername());
    }
}
