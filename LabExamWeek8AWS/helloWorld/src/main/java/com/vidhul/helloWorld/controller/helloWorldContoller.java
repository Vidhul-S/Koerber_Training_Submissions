package com.vidhul.helloWorld.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class helloWorldContoller {

    @RequestMapping("hello")
    public String hello(){
        return "Hello World";
    }
}
