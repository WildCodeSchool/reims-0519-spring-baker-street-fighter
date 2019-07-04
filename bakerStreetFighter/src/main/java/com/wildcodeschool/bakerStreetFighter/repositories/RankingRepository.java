package com.wildcodeschool.bakerStreetFighter.repositories;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import com.wildcodeschool.bakerStreetFighter.entities.Ranking;

public class RankingRepository {

    private final static String DB_URL = "jdbc:mysql://localhost:3306/wild_db_quest?serverTimezone=GMT";
    private final static String DB_USER = "root";
    private final static String DB_PASSWORD = "@ps745GF";

    public static List<Ranking> getRanking() {
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
                List<Ranking> wizards = new ArrayList<Ranking>();

                while(resulSet.next()){
                    int id = resulSet.getInt("id");
                    String nickname = resulSet.getString("nickname");
                    String name = resulSet.getString("name");
                    int victory_count = resulSet.getInt("victory_count");
                    int defeat_count  = resulSet.getInt("defeat_count");

                    wizards.add(new Ranking(id, nickname, name, victory_count, defeat_count));
                }

                return wizards;
            }
        }
        catch (SQLException e) {
            throw new ResponseStatusException(
                HttpStatus.INTERNAL_SERVER_ERROR, "", e
            );
        }
    }

}