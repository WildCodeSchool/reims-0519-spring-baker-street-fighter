package com.wildcodeschool.bakerStreetFighter.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
class FighterController {

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/rules")
    public String rules() {
        return "rules";
    }

    @GetMapping("/fight")
    public String fight() {
        return "fight";
    }

    @GetMapping("/ranking")
    public String ranking() {
        return "ranking";
    }
    
}