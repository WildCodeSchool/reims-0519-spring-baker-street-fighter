package com.wildcodeschool.bakerStreetFighter.controllers;

import javax.servlet.http.HttpSession;

import com.wildcodeschool.bakerStreetFighter.repositories.FighterRepository;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
class FighterController {

    private static FighterRepository fighterRepository = new FighterRepository();
    
    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/rules")
    public String rules() {
        return "rules";
    }

    @GetMapping("/ranking")
    public String ranking() {
        return "ranking";
    }

    @GetMapping("/win")
    public String winner(Model model, HttpSession session) {
        model.addAttribute("currentPlayer", session.getAttribute("currentPlayer").equals(1) ? "Sherlock" : "Moriarty");
        return "winner";
    }

    @GetMapping("/fight")
    public String fight(Model model, HttpSession session) {

        if(session.getAttribute("currentPlayer") == null) {
            double probability = Math.random();
            if(probability > 0.5) {
                session.setAttribute("currentPlayer", 1);
            } 
            else {
                session.setAttribute("currentPlayer", 2);
            }
        }

        model.addAttribute("currentPlayer", session.getAttribute("currentPlayer").equals(1) ? "Sherlock" : "Moriarty");
        model.addAttribute("currentOppenent", session.getAttribute("currentPlayer").equals(2) ? "Sherlock" : "Moriarty");
        model.addAttribute("lifeP1", fighterRepository.getFighterById(1).getLife());
        model.addAttribute("lifeP2", fighterRepository.getFighterById(2).getLife());

        return "fight";
    }

    @PostMapping("/fight")
    public String fight(Model model, HttpSession session, @RequestParam(required = false) String attack) {

        boolean fight = true;

        if(attack != null) { 

            int currentOpponent = 2;
            if(!session.getAttribute("currentPlayer").equals(1)) {
                currentOpponent = 1;
            }
            
            int hit = FighterRepository.punch();
            if(attack.equals("uppercut")) {
                hit = FighterRepository.uppercut();
            }

            fighterRepository.getFighterById(currentOpponent).takeHit(hit);

            if(fighterRepository.getFighterById(currentOpponent).getLife() == 0) {
                fight = false;
            } else {
                session.setAttribute("currentPlayer", currentOpponent);
            }
        }

        if(fight) {
            return "redirect:/fight";
        } 
        else { 
            return "redirect:/win";
        }
    }    
}