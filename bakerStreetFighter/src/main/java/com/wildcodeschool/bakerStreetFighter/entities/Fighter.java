package com.wildcodeschool.bakerStreetFighter.entities;

public class Fighter extends Player{
    
    private int life;

    public Fighter(int id, String name, int victoryCount, int defeatCount) {
        super(id, name, victoryCount, defeatCount);
        this.life = 100;
    }

    public int getLife() {
        return life;
    }

    public void setLife(int life) {
        this.life = life;
    }

    public void takeHit(int hit) {
        this.setLife(Math.max(this.getLife() - hit, 0));
    }

}