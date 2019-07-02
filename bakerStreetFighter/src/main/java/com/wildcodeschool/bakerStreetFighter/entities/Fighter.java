package com.wildcodeschool.bakerStreetFighter.entities;

public class Fighter extends Player{
    
    private int life;

    public Fighter(int id, String name, int victory, int loose) {
        super(id, name, victory, loose);
        this.life = 100;
    }

    public int getLife() {
        return life;
    }

    public void setLife(int life) {
        this.life = life;
    }

}