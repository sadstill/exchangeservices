package com.sadstill.app.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestHandler {

    @RequestMapping("/testing")
    public String getHello() {
        return "teeesting hello";
    }
}
