package com.wildcodeschool.bakerStreetFighter.repositories;

import com.wildcodeschool.bakerStreetFighter.entities.Fighter;

import java.util.ArrayList;
import java.util.List;

class FighterRepository {
    
    private List<Fighter> fighters;

    public FighterRepository() {
        this.fighters = new ArrayList<Fighter>();
        fighters.add(new Fighter(1, "Sherlock Holmes", 0, 0));
        fighters.add(new Fighter(2, "Professeur Moriarty", 0, 0));
    }

}