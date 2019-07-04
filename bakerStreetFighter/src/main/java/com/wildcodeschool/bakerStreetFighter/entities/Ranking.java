package com.wildcodeschool.bakerStreetFighter.entities;

public class Ranking {

    private int id;
    private String nickname;
    private String name;
    private int victory_count;
    private int defeat_count;

    public Ranking(int id, String nickname, String name, int victory_count, int defeat_count) {
        this.id = id;
        this.nickname = nickname;
        this.name = name;
        this.victory_count = victory_count;
        this.defeat_count = defeat_count;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
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
    
}