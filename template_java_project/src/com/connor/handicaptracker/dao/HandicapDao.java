package com.connor.handicaptracker.dao;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBQueryExpression;
import com.connor.handicaptracker.dao.models.Handicap;
import com.connor.handicaptracker.exceptions.CourseNotFoundException;
import com.connor.handicaptracker.exceptions.HandicapNotFoundException;

import javax.inject.Inject;
import java.util.List;

/**
 * Accesses data for a handicap using {@link Handicap} to represent the model in DynamoDB.
 */
public class HandicapDao {
    private final DynamoDBMapper dynamoDbMapper;

    /**
     * Instantiates a HandicapDao object.
     *
     * @param dynamoDbMapper the {@link DynamoDBMapper} used to interact with the handicaps table
     */
    @Inject
    public HandicapDao(DynamoDBMapper dynamoDbMapper) {
        this.dynamoDbMapper = dynamoDbMapper;
    }

    /**
     * Returns the {@link Handicap} corresponding to the specified username.
     *
     * @param  username   the Player username

     * @return the stored course, or null if none was found.
     */
    public Handicap getHandicap(String username, double handicapIndex) {
        Handicap handicap = this.dynamoDbMapper.load(Handicap.class, username, handicapIndex);

        if (handicap == null) {
            throw new HandicapNotFoundException("Could not find handicap with username " + username);
        }

        return handicap;
    }

    public Handicap saveHandicap(Handicap handicap) {
        dynamoDbMapper.save(handicap);
        return handicap;
    }

    private Handicap getHandicapByUsername(String username) {
        Handicap handicap = new Handicap();
        handicap.setUsername(username);

        DynamoDBQueryExpression<Handicap> queryExpression = new DynamoDBQueryExpression()
                .withHashKeyValues(username)
                .withScanIndexForward(false)
                .withLimit(1);

        List<Handicap> results = dynamoDbMapper.query(Handicap.class, queryExpression);
        if (results.isEmpty()) {
            return null;
        }
        return results.get(0);
    }
}
