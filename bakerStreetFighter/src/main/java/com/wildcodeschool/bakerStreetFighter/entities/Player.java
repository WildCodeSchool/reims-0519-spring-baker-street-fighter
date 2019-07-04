package com.wildcodeschool.bakerStreetFighter.entities;

public class Player {

    private int id;
    private String name;
    private int victory_count;
    private int defeat_count;
    private int total_games_played;

    public Player(int id, String name, int victory_count, int defeat_count, int total_games_played) {
        this.id = id;
        this.name = name;
        this.victory_count = victory_count;
        this.defeat_count = defeat_count;
        this.total_games_played = total_games_played;
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

    public int getVictory_count() {
        return victory_count;
    }

    public void setVictory_count(int victory_count) {
        this.victory_count = victory_count;
    }

    public int getDefeat_count() {
        return defeat_count;
    }

    public void setDefeat_count(int defeat_count) {
        this.defeat_count = defeat_count;
    }

    public int getTotal_games_played() {
        return total_games_played;
    }

    public void setTotal_games_played(int total_games_played) {
        this.total_games_played = total_games_played;
    }

}