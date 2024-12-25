package com.initapi.firstspring.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // Bu sınıf API'nin kontrol merkezi
public class HelloController {

    // Tarayıcıda http://localhost:8080/hello ile ulaşabilirsin
    @GetMapping("/hello") 
    public String sayHello() {
        return "Hello, Spring API!";
    }
}
