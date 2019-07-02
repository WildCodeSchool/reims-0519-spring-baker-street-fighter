package com.wildcodeschool.bakerStreetFighter.entities;

public class Player {

    private int id;
    private String name;
    private int totalGamesPlayed;
    private int victory;
    private int defeat;

    public Player(int id, String name, int victory, int defeat) {
        this.id = id;
        this.name = name;
        this.totalGamesPlayed = totalGamesPlayed;
        this.victory = victory;
        this.defeat = defeat;
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

    public int getDefeat() {
        return defeat;
    }

    public void setDefeat(int defeat) {
        this.defeat = defeat;
    }

    public int getTotalGamesPlayed() {
        return totalGamesPlayed;
    }

    public void setTotalGamesPlayed(int totalGamesPlayed) {
        this.totalGamesPlayed = totalGamesPlayed;
    }

}