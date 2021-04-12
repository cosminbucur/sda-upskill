package com.sda.spring.security.database.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DefaultController {

    @GetMapping("/")
    public String home() {
        return "/index";
    }

    @GetMapping("/admin")
    public String admin() {
        return "/admin";
    }

    @GetMapping("/user")
    public String user() {
        return "/user";
    }

    @GetMapping("/public")
    public String about() {
        return "/public";
    }

    // unauthorized
    @GetMapping("/403")
    public String error403() {
        return "/error/403";
    }
}
