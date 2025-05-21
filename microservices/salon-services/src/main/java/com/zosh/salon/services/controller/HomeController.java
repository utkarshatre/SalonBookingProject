package com.zosh.salon.services.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/")
public class HomeController {
    @GetMapping
    public String HomeController(){
        return "Home Controler of Saloon microServcice";
    }
}
