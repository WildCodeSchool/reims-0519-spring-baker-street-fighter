package com.wildcodeschool.bakerStreetFighter.repositories;

import java.util.ArrayList;
import java.util.List;

import com.wildcodeschool.bakerStreetFighter.entities.Fighter;

class FighterRepository {
    
    private List<Fighter> fighters;

    public FighterRepository() {
        this.fighters = new ArrayList<Fighter>();
        fighters.add(new Fighter(1, "Sherlock Holmes", 0, 0));
        fighters.add(new Fighter(2, "Professeur Moriarty", 0, 0));
    }

    public List<Fighter> getFighters() {
        return fighters;
    }

    public Fighter getFighterById(int id) {
        for(Fighter fighter : fighters) {
            if(fighter.getId() == id) {
                return fighter;
            }
        }
        return null;
    }

}