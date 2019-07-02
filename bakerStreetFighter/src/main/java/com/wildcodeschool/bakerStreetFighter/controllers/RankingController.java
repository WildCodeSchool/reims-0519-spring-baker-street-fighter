package com.wildcodeschool.bakerStreetFighter.controllers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.sql.SQLException;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.server.ResponseStatusException;

@Controller
@ResponseBody
public class RankingController<Ranking> {

    private final static String DB_URL = "jdbc:mysql://localhost:3306/wild_db_quest?serverTimezone=GMT";
    private final static String DB_USER = "baker";
    private final static String DB_PASSWORD = "Fighter51!";

    @GetMapping("/ranking")
    public List<Ranking> getRankings(@RequestParam(defaultValue = "%") String country) {
        try(
            Connection connection = DriverManager.getConnection(
                DB_URL, DB_USER, DB_PASSWORD
            );
            PreparedStatement statement = connection.prepareStatement(
                "SELECT * FROM fighter"
            );
        ) {
            statement.setString(1, country);
    
            try(
                ResultSet resulSet = statement.executeQuery();
            ) {
                List<Ranking> rankings = new ArrayList<Ranking>();
    
                while(resulSet.next()){
                    int id = resulSet.getInt("id");
                    String name = resulSet.getString("name");
                    int totalGamesPlayed = resulSet.getInt("totalGamesPlayed");
                    int victory = resulSet.getInt("victory");
                    int defeat = resulSet.getInt("defeat");
                    rankings.add(new Player.Player(id, name, totalGamesPlayed, victory, defeat));
                }
    
                return rankings;
            }
        }
        catch (SQLException e) {
            throw new ResponseStatusException(
                HttpStatus.INTERNAL_SERVER_ERROR, "", e
            );
        }
    }
}