package com.abcbank.test;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;

@RestController
public class TestController {

    @GetMapping("/test")
    public String test() {
        return "test@" + Instant.now();
    }
}
