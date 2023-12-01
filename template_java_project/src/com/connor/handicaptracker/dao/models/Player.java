package com.connor.handicaptracker.dao.models;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAutoGeneratedKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

import java.util.List;

@DynamoDBTable(tableName = "players")
public class Player {
    @DynamoDBHashKey
    @DynamoDBAutoGeneratedKey
    private String username;

    // avatar will be a string that contains a url to a .png .img file

    private String email;

    private List<Rounds> rounds;

    private double handicap;


    public Player(String username, String email, List<Rounds> rounds, double handicap) {
        this.username = username;

        this.email = email;

        this.rounds = rounds;
        this.handicap = handicap;
        }

    public Player() {

    }

    public String getUsername() {
            return username;
        }


    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
            return email;
        }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Rounds> getRounds() {
        return rounds;
    }

    public void setRounds(List<Rounds> rounds) {
        this.rounds = rounds;
    }

    // the sethandicap should be replaced by a calculatehandicap?
    public void setHandicap(double handicap) {
        this.handicap = handicap;
    }

    public double getHandicap() {
            return handicap;
        }

//        private double calculateHandicap() {
//            // Implement handicap calculation logic
//        return handicap;
//    }
}
