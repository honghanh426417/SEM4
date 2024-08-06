package com.example.menusecurity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ContentController {
    @GetMapping("/login")
    public String handleLogin() {
        return "menu/custom_login"; // Trả về tên view "login"
    }
}
