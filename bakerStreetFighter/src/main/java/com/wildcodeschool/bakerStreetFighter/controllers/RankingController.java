package com.wildcodeschool.bakerStreetFighter.controllers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.wildcodeschool.bakerStreetFighter.entities.Player;

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

    private final static String DB_URL = "jdbc:mysql://localhost:3306/baker_street_fighter?serverTimezone=GMT";
    private final static String DB_USER = "baker";
    private final static String DB_PASSWORD = "Fighter51!";

    @GetMapping("/ranking")
    public List<Ranking> getRankings(@RequestParam(defaultValue = "%") String country) {
        try(
            Connection connection = DriverManager.getConnection(
                DB_URL, DB_USER, DB_PASSWORD
            );
            PreparedStatement statement = connection.prepareStatement(
                "SELECT * FROM fighter WHERE name LIKE ?"
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
                    String nickname = resulSet.getString("nickname");
                    int victory_count = resulSet.getInt("victory_count");
                    int defeat_count = resulSet.getInt("defeat_count");
                    rankings.add(new Ranking(id, nickname, name, victory_count, defeat_count));
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

    class Ranking {

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

}