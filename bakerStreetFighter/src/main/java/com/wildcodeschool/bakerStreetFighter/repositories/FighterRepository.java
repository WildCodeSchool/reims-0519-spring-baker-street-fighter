package com.wildcodeschool.bakerStreetFighter.repositories;

import com.wildcodeschool.bakerStreetFighter.entities.Fighter;

import java.util.ArrayList;
import java.util.List;

class FighterRepository {

    private final static String DB_URL = "jdbc:mysql://localhost:3306/wild_db_quest?serverTimezone=GMT";
    private final static String DB_USER = "baker";
    private final static String DB_PASSWORD = "Fighter51!";

    private List<Fighter> fighters;

    public FighterRepository() {
        this.fighters = new ArrayList<Fighter>();
        fighters.add(new Fighter(1, "Sherlock Holmes"));
        fighters.add(new Fighter(2, "Professeur Moriarty"));
    }

}