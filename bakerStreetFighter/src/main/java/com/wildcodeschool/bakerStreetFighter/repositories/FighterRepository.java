package com.wildcodeschool.bakerStreetFighter.repositories;

import java.util.ArrayList;
import java.util.List;

import com.wildcodeschool.bakerStreetFighter.entities.Fighter;

public class FighterRepository {

    private final static String DB_URL = "jdbc:mysql://localhost:3306/wild_db_quest?serverTimezone=GMT";
    private final static String DB_USER = "baker";
    private final static String DB_PASSWORD = "Fighter51!";
    
    private List<Fighter> fighters;

    public FighterRepository() {
        this.fighters = new ArrayList<Fighter>();
        fighters.add(new Fighter(1, "Sherlock Holmes"));
        fighters.add(new Fighter(2, "Professeur Moriarty"));
    }

    public Fighter getFighterById(int id) {
        for(Fighter fighter : fighters) {
            if(fighter.getId() == id) {
                return fighter;
            }
        }
        return null;
    }

    public static int uppercut() {
        double probability = Math.random();
        int damage = 30;
        if (probability > 0.5) {
            return damage;
        } else {
            return 0;
        }
    }

    public static int punch() {
        double probability = Math.random();
        int damage = 10;
        if (probability > 0.2) {
            return damage;
        } else {
            return 0;
        }
    }

}