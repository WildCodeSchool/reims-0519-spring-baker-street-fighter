package com.wildcodeschool.bakerStreetFighter.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
class FighterController {

    @GetMapping("/home")
    public String index(Model model) {
        return "index";
    }

    @GetMapping("/home/rules")
    public String rules(Model model) {
        return "rules";
    }

    @GetMapping("/home/fight")
    public String fight(Model model) {
        return "fight";
    }

    @GetMapping("/home/ranking")
    public String ranking(Model model) {
        return "ranking";
    }
    
}