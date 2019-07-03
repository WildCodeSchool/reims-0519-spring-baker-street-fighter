package com.wildcodeschool.bakerStreetFighter.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

    @PostMapping("/fight")
    public String fight(Model model, HttpSession session, @RequestParam(required = false) String attack) {

        if(attack != null) {
            // TODO fight here
        }

        if(!false) { 
            return "redirect:/fight";
        }
        else {
            return "redirect:/";
        }


    }

    
}