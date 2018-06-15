package com.example.demojava10;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping(path = "/")
    public String hello() {
        var s = "Hello Java 10!";
        return s;
    }
}
