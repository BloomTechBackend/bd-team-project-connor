package com.connor.handicaptracker.dao;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBQueryExpression;
import com.connor.handicaptracker.dao.models.Rounds;
import com.connor.handicaptracker.exceptions.RoundNotFoundException;
//import com.connor.roundtracker.dao.models.Rounds;
//import com.connor.roundtracker.dao.models.Player;
//import com.connor.roundtracker.dao.models.Rounds;
//import com.connor.roundtracker.exceptions.RoundNotFoundException;

import javax.inject.Inject;
import java.util.List;

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



    public Rounds getRound(String date, double score) {
        Rounds round = this.dynamoDbMapper.load(Rounds.class, date, score);

        if (round == null) {
            throw new RoundNotFoundException("Could not find round with date " + date);
        }

        return round;
    }

    public Rounds getRoundsByDate(String date, double score) {
        Rounds round = new Rounds();
        round.setDate(date);
        round.setScore(score);
        DynamoDBQueryExpression<Rounds> queryExpression = new DynamoDBQueryExpression()
                .withHashKeyValues(round)
                .withScanIndexForward(false)
                .withLimit(1);

        List<Rounds> results = dynamoDbMapper.query(Rounds.class, queryExpression);
        if (results.isEmpty()) {
            return null;
        }
        return results.get(0);
    }


}
