package com.initapi.firstspring.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ResourceController {

    @GetMapping("/protected/resource")
    public String getProtectedResource() {
        return "This is a protected resource.";
    }
}
