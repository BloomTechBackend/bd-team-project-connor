package com.connor.handicaptracker.dao;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.connor.handicaptracker.dao.models.Player;
import com.connor.handicaptracker.dao.models.Rounds;
import com.connor.handicaptracker.exceptions.RoundNotFoundException;

import javax.inject.Inject;

public class RoundsDao {
    //private Player player;

    private final DynamoDBMapper dynamoDbMapper;

    /**
     * Instantiates a RoundsDao object.
     *
     * @param dynamoDbMapper the {@link DynamoDBMapper} used to interact with the rounds table
     */
    @Inject
    public RoundsDao(DynamoDBMapper dynamoDbMapper) {
        this.dynamoDbMapper = dynamoDbMapper;
    }

//    public Rounds getAll(Player player){
//        Rounds rounds = ;
//
//
//        //return (Rounds) player.getRounds();
//    }



    public Rounds getRound(String date, int score) {
        Rounds round = this.dynamoDbMapper.load(Rounds.class, date, score);

        if (round == null) {
            throw new RoundNotFoundException("Could not find round with date " + date);
        }

        return round;
    }


}
