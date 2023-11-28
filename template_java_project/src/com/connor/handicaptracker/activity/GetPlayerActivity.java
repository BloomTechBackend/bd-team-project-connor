package com.connor.handicaptracker.activity;

import com.amazonaws.auth.DefaultAWSCredentialsProviderChain;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.connor.handicaptracker.converter.ModelConverter;
import com.connor.handicaptracker.dao.PlayerDao;
import com.connor.handicaptracker.dao.models.Player;
import com.connor.handicaptracker.models.PlayerModel;
import com.connor.handicaptracker.models.requests.GetPlayerRequest;
import com.connor.handicaptracker.models.results.GetPlayerResult;


import javax.inject.Inject;
import java.util.logging.LogManager;
import java.util.logging.Logger;

/**
 * Implementation of the GetPlayerActivity for the HandicapTrackerService GetPlayer API.
 *
 * This API allows the player to get their profile.
 */
public class GetPlayerActivity implements RequestHandler<GetPlayerRequest, GetPlayerResult> {

    private final PlayerDao playerDao;

    /**
     * Instantiates a new GetPlayerActivity object.
     *
     * @param playerDao PlayerDao to access the players table.
     */

    @Inject
    public GetPlayerActivity(PlayerDao playerDao) {
        this.playerDao = playerDao;
    }

    public GetPlayerActivity() {
        //playerDao = new PlayerDao(new DynamoDBMapper(DynamoDbClientProvider.getDynamoDBClient(Regions.US_WEST_2)));
        this.playerDao = new PlayerDao(new DynamoDBMapper((AmazonDynamoDB)((AmazonDynamoDBClientBuilder)((AmazonDynamoDBClientBuilder)AmazonDynamoDBClientBuilder.standard().withCredentials(DefaultAWSCredentialsProviderChain.getInstance())).withRegion(Regions.US_WEST_2)).build()));
    }

    /**
     * This method handles the incoming request by retrieving the player from the database.
     * <p>
     * It then returns the player profile.
     * <p>
     * If the player does not exist, this should throw a PlayerNotFoundException.
     *
     * @param getPlayerRequest request object containing the player username
     * @return getPlayerResult result object containing the API defined {@link PlayerModel}
     */
    @Override
    public GetPlayerResult handleRequest(final GetPlayerRequest getPlayerRequest, Context context) {
        //log.info("Received GetPlayerRequest {}", getPlayerRequest);
        String requestedUsername = getPlayerRequest.getUsername();
        Player player = playerDao.getPlayer(requestedUsername);
        PlayerModel playerModel = new ModelConverter().toPlayerModel(player);

        return GetPlayerResult.builder()
                .withPlayer(playerModel)
                .build();
    }
}