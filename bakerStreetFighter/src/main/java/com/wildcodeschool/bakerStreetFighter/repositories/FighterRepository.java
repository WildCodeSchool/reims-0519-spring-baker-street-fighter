package com.wildcodeschool.bakerStreetFighter.repositories;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.wildcodeschool.bakerStreetFighter.entities.Fighter;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class FighterRepository {

    private final static String DB_URL = "jdbc:mysql://localhost:3306/baker_street_fighter?serverTimezone=GMT";
    private final static String DB_USER = "baker";
    private final static String DB_PASSWORD = "Fighter51!";
    
    private List<Fighter> fighters;

    public FighterRepository() {
        this.fighters = new ArrayList<Fighter>();
        fighters.add(new Fighter(1, "Sherlock Holmes", 0, 0, 0));
        fighters.add(new Fighter(2, "Professeur Moriarty", 0, 0, 0));
    }

    public Fighter getFighterById(int id) {
        for(Fighter fighter : fighters) {
            if(fighter.getId() == id) {
                return fighter;
            }
        }
        return null;
    }

    public static int uppercut() {
        double probability = Math.random();
        int damage = 30;
        if (probability > 0.5) {
            return damage;
        } else {
            return 0;
        }
    }

    public static int punch() {
        double probability = Math.random();
        int damage = 10;
        if (probability > 0.2) {
            return damage;
        } else {
            return 0;
        }
    }

    public List<Fighter> getRankingFighter() {
        try(
            Connection connection = DriverManager.getConnection(
                DB_URL, DB_USER, DB_PASSWORD
            );
            PreparedStatement statement = connection.prepareStatement(
                "SELECT * FROM fighter"
            );
        ) {
            try(
                ResultSet resulSet = statement.executeQuery();
            ) {
                List<Fighter> fighters = new ArrayList<Fighter>();

                while(resulSet.next()){
                    int id = resulSet.getInt("id");
                    String name = resulSet.getString("name");
                    int victory_count = resulSet.getInt("victory_count");
                    int defeat_count = resulSet.getInt("defeat_count");
                    int total_games_played = resulSet.getInt("total_games_played");

                    fighters.add(new Fighter(id, name, victory_count, defeat_count, total_games_played));
                }

                return fighters;
            }
        }
        catch (SQLException e) {
            throw new ResponseStatusException(
                HttpStatus.INTERNAL_SERVER_ERROR, "", e
            );
        }
    }

}