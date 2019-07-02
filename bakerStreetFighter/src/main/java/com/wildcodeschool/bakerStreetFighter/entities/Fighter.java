package com.wildcodeschool.bakerStreetFighter.entities;

class Fighter {
    
    private String name;
    private int life;

    public Fighter(String name) {
        this.name = name;
        this.life = 100;
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
    
}