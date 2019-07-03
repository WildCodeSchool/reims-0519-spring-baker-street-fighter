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
    public String fight(Model model, HttpSession session) {
        if(session.getAttribute("currentPlayer") == null) {
            
            double probability = Math.random();
            if(probability > 0.5){
                session.setAttribute("currentPlayer", 1);
            } else{
                session.setAttribute("currentPlayer", 2);
            }
        }

        model.addAttribute("currentPlayer", session.getAttribute("currentPlayer").equals(1) ? "Sherlock" : "Moriarty");
        return "fight";
    }

    @GetMapping("/ranking")
    public String ranking() {
        return "ranking";
    }

    @PostMapping("/fight")
    public String fight(Model model, HttpSession session, @RequestParam(required = false) String attack) {

        boolean fight = true;

        if(attack != null) {
            if(attack.equals("punch")) {

            } else {

            }
        }

        // next player can play now
        if(session.getAttribute("currentPlayer").equals(1)) {
            session.setAttribute("currentPlayer", 2);
        }
        else {
            session.setAttribute("currentPlayer", 1);
        }

        if(fight) {
            return "redirect:/fight";
        }
        else {
            return "redirect:/";
        }
    }    

    
}