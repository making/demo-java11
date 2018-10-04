package com.example.demojava11;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping(path = "/")
    public String hello() {
        var s = "Hello Java 11!";
        return s;
    }
}
