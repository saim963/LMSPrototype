package com.SStech.LMSPrototype.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping({"","/"})
    public String index(){
        return "index";
    }
    @GetMapping({"/upcoming-dues"})
    public String upcomingDues(){
        return "upcoming-dues";
    }
    @GetMapping({"/contact"})
    public String contact(){
        return "contact";
    }
    @GetMapping({"/privacy"})
    public String privacy(){
        return "privacy";
    }
    
}
