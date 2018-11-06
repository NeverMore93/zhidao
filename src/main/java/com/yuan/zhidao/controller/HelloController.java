package com.yuan.zhidao.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping(value = "/hello")
    public String hello(){
        return "hello zhidao";
    }

    @GetMapping(value = "/")
    public String home(){
        return "hello home";
    }


}
