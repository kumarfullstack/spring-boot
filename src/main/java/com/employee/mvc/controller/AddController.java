package com.employee.mvc.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AddController {

//    @RequestMapping("/home")
    @GetMapping("/home")
    public String home() {
        return "index";
    }

    @RequestMapping("/add")
    public void add() {

    }
}
