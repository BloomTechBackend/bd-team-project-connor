package com.connor.handicaptracker.activity;

import com.amazonaws.auth.DefaultAWSCredentialsProviderChain;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.connor.handicaptracker.converter.ModelConverter;
import com.connor.handicaptracker.dao.HandicapDao;
import com.connor.handicaptracker.dao.PlayerDao;
import com.connor.handicaptracker.dao.models.Handicap;
import com.connor.handicaptracker.dao.models.Player;
import com.connor.handicaptracker.lambda.GetHandicapActivityProvider;
import com.connor.handicaptracker.models.HandicapModel;
import com.connor.handicaptracker.models.PlayerModel;
import com.connor.handicaptracker.models.requests.GetHandicapRequest;
import com.connor.handicaptracker.models.requests.GetPlayerRequest;
import com.connor.handicaptracker.models.results.GetHandicapResult;
import com.connor.handicaptracker.models.results.GetPlayerResult;

import javax.inject.Inject;
import java.util.logging.LogManager;
import java.util.logging.Logger;

/**
 * Implementation of the GetPlayerActivity for the HandicapTrackerService GetPlayer API.
 *
 * This API allows the player to get their profile.
 */
public class GetHandicapActivity implements RequestHandler<GetHandicapRequest, GetHandicapResult> {

    //private final PlayerDao playerDao;
    private final PlayerDao handicapDao;

    /**
     * Instantiates a new GetPlayerActivity object.
     *
     * @param handicapDao handicapDao to access the players table.
     */

    @Inject
    public GetHandicapActivity(PlayerDao handicapDao) {
        this.handicapDao = handicapDao;
    }

    public GetHandicapActivity() {
        //playerDao = new PlayerDao(new DynamoDBMapper(DynamoDbClientProvider.getDynamoDBClient(Regions.US_WEST_2)));
        this.handicapDao = new PlayerDao(new DynamoDBMapper((AmazonDynamoDB)((AmazonDynamoDBClientBuilder)((AmazonDynamoDBClientBuilder)AmazonDynamoDBClientBuilder.standard().withCredentials(DefaultAWSCredentialsProviderChain.getInstance())).withRegion(Regions.US_WEST_2)).build()));
    }

    /**
     * This method handles the incoming request by retrieving the player's handicap from the database.
     * <p>
     * It then returns the player's handicap.
     * <p>
     * If the Handicap does not exist, this should throw a HandicapNotFoundException.
     *
     * @param getHandicapRequest request object containing the player username and index
     * @return getHandicapResult result object containing the API defined {@link HandicapModel}
     */
    @Override
    public GetHandicapResult handleRequest(final GetHandicapRequest getHandicapRequest, Context context) {

        String requestedUsername = getHandicapRequest.getUsername();
        //double requestedHandicap = getHandicapRequest.getHandicap();


        Player player = handicapDao.getPlayer(requestedUsername);
        Handicap handicap = new Handicap();
        handicap.setUsername(player.getUsername());
        handicap.setHandicapIndex(player.getHandicap());
       // Handicap handicap = handicapDao.getHandicap(requestedUsername, requestedHandicap);
        //Handicap handicap = handicapDao.getHandicap(requestedHandicap);
        HandicapModel handicapModel = new ModelConverter().toHandicapModel(handicap);

        return GetHandicapResult.builder()
                .withHandicap(handicapModel)
                .build();
    }
}
