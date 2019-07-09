package com.wildcodeschool.bakerStreetFighter.controllers;

import javax.servlet.http.HttpSession;

import com.wildcodeschool.bakerStreetFighter.entities.Fighter;
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
    public String ranking(Model model) {
        model.addAttribute("fighters", fighterRepository.getRankingFighter());
        return "ranking";
    }

    @GetMapping("/win")
    public String winner(Model model, HttpSession session) {
        Fighter sherlock = fighterRepository.getRankingFighter().get(0);
        Fighter moriarty = fighterRepository.getRankingFighter().get(1);

        if(session.getAttribute("currentPlayer").equals(sherlock.getId())) {
            sherlock.setVictoryCount(sherlock.getVictoryCount()+1);
            moriarty.setDefeatCount(moriarty.getDefeatCount()+1);

            model.addAttribute("currentPlayer", sherlock.getName());
        }
        else {
            sherlock.setDefeatCount(sherlock.getDefeatCount()+1);
            moriarty.setVictoryCount(moriarty.getVictoryCount()+1);

            model.addAttribute("currentPlayer", moriarty.getName());
        }

        FighterRepository.updateScore(sherlock.getId(), sherlock.getName(), sherlock.getVictoryCount(), sherlock.getDefeatCount());
        FighterRepository.updateScore(moriarty.getId(), moriarty.getName(), moriarty.getVictoryCount(), moriarty.getDefeatCount());

        fighterRepository.getFighterById(1).setLife(100);
        fighterRepository.getFighterById(2).setLife(100);

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

        model.addAttribute("message", "Let the battle begin");
        if(session.getAttribute("lastAttackFailed") != null) {
            if(session.getAttribute("lastAttackFailed").equals(false)) {
                model.addAttribute("message", "The attack worked");
            }
            else {
                model.addAttribute("message", "The attack failed");
            }
        }
        model.addAttribute("currentPlayer", session.getAttribute("currentPlayer").equals(1) ? "Sherlock" : "Moriarty");
        model.addAttribute("lifeP1", fighterRepository.getFighterById(1).getLife());
        model.addAttribute("lifeP2", fighterRepository.getFighterById(2).getLife());

        return "fight";
    }

    @PostMapping("/fight")
    public String fight(HttpSession session, @RequestParam(required = false) String attack) {

        boolean fight = true;

        if(attack != null) { 

            int currentOpponent = 2;
            if(!session.getAttribute("currentPlayer").equals(1)) {
                currentOpponent = 1;
            }
            
            int hit = 0;
            if(attack.equals("uppercut")) {
                hit = FighterRepository.uppercut();
            }
            else {
                hit = FighterRepository.punch();
            }

            if(hit > 0) {
                session.setAttribute("lastAttackFailed", false);
                fighterRepository.getFighterById(currentOpponent).takeHit(hit);
            } else {
                session.setAttribute("lastAttackFailed", true);
            }

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