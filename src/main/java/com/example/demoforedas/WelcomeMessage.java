package com.example.demoforedas;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeMessage {
    @GetMapping(value = "/test")
    public String welcomeMessage() {
        return "hello world";
    }
}
