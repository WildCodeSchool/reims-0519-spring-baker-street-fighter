package com.wildcodeschool.bakerStreetFighter.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
class FighterController {

    @GetMapping("/")
    public String index(Model model) {
        return "index";
    }

    @GetMapping("/rules")
    public String rules(Model model) {
        return "rules";
    }

    @GetMapping("/fight")
    public String fight(Model model) {
        return "fight";
    }

    @GetMapping("/ranking")
    public String ranking(Model model) {
        return "ranking";
    }
    
}