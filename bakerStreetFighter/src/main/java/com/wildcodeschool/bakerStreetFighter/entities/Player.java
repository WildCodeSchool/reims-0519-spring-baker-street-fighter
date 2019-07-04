package com.wildcodeschool.bakerStreetFighter.entities;

public class Player {

    private int id;
    private String name;
    private int victory;
    private int loose;

    public Player(int id, String name) {
        this.id = id;
        this.name = name;
        this.victory = 0;
        this.loose = 0;
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

    public int getVictory() {
        return victory;
    }

    public void setVictory(int victory) {
        this.victory = victory;
    }

    public int getLoose() {
        return loose;
    }

    public void setLoose(int loose) {
        this.loose = loose;
    }

}