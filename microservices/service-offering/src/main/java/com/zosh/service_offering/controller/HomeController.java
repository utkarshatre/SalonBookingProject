package com.zosh.service_offering.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
            @GetMapping
        public String HomeControllerHandler(){
            return "HOme Controller for the Service Offering";
        }
}
