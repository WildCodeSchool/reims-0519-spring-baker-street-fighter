package com.wildcodeschool.bakerStreetFighter.entities;

public class Fighter {
    
    private int id;
    private String name;
    private int life;
    private int victory;

    public Fighter(int id, String name) {
        this.id = id;
        this.name = name;
        this.life = 100;
        this.victory = 0;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLife() {
        return life;
    }

    public void setLife(int life) {
        this.life = life;
    }

    public int getVictory() {
        return victory;
    }

    public void setVictory(int victory) {
        this.victory = victory;
    }

}