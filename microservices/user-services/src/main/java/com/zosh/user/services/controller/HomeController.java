package com.zosh.user.services.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    @GetMapping
    public String HomeController(){
        return "USer Service_SaloonProject Api Response at 8080";
    }
}
