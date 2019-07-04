package com.wildcodeschool.bakerStreetFighter.entities;

public class Fighter extends Player{
    
    private int life;

    public Fighter(int id, String name, int victory_count, int defeat_count, int total_games_played) {
        super(id, name, victory_count, defeat_count, total_games_played);
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