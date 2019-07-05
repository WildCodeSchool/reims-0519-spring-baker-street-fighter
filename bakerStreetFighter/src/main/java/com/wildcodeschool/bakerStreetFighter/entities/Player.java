package com.wildcodeschool.bakerStreetFighter.entities;

public class Player {

    private int id;
    private String name;
    private int victoryCount;
    private int defeatCount;

    public Player(int id, String name, int victoryCount, int defeatCount) {
        this.id = id;
        this.name = name;
        this.victoryCount = victoryCount;
        this.defeatCount = defeatCount;
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

    public int getVictoryCount() {
        return victoryCount;
    }

    public void setVictoryCount(int victoryCount) {
        this.victoryCount = victoryCount;
    }

    public int getDefeatCount() {
        return defeatCount;
    }

    public void setDefeatCount(int defeatCount) {
        this.defeatCount = defeatCount;
    }

}