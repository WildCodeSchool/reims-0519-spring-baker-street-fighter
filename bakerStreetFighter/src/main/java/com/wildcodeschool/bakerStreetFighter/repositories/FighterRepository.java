package com.wildcodeschool.bakerStreetFighter.repositories;

import com.wildcodeschool.bakerStreetFighter.entities.Fighter;

import java.util.ArrayList;
import java.util.List;

class FighterRepository {

    private List<Fighter> fighters;

    public FighterRepository() {
        this.fighters = new ArrayList<Fighter>();
        fighters.add(new Fighter(1, "Sherlock Holmes"));
        fighters.add(new Fighter(2, "Professeur Moriarty"));
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