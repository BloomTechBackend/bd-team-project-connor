package com.connor.handicaptracker.activity;

import com.amazonaws.auth.DefaultAWSCredentialsProviderChain;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.Table;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.connor.handicaptracker.converter.ModelConverter;
import com.connor.handicaptracker.dao.PlayerDao;
import com.connor.handicaptracker.dao.models.Player;
import com.connor.handicaptracker.dao.models.Rounds;
import com.connor.handicaptracker.exceptions.RoundNotFoundException;
import com.connor.handicaptracker.models.PlayerModel;
import com.connor.handicaptracker.models.requests.CreatePlayerRequest;
import com.connor.handicaptracker.models.results.CreatePlayerResult;
import com.connor.handicaptracker.util.HandicapServiceUtils;

import javax.inject.Inject;
import javax.management.InvalidAttributeValueException;
import java.util.ArrayList;
import java.util.List;


/**
 * Implementation of the CreatePlayerActivity for the API.
 *
 * This API allows the customer to create a new player with a handicap.
 */
public class CreatePlayerActivity implements RequestHandler<CreatePlayerRequest, CreatePlayerResult> {

    private final PlayerDao playerDao;

    /**
     * Instantiates a new CreatePlayerActivity object.
     *
     * @param playerDao PlayerDao to access the players table.
     */
    @Inject
    public CreatePlayerActivity(PlayerDao playerDao) {
        this.playerDao = playerDao;
    }

    public CreatePlayerActivity() {
        //playerDao = new PlayerDao(new DynamoDBMapper(DynamoDbClientProvider.getDynamoDBClient(Regions.US_WEST_2)));
        this.playerDao = new PlayerDao(new DynamoDBMapper((AmazonDynamoDB)((AmazonDynamoDBClientBuilder)((AmazonDynamoDBClientBuilder)AmazonDynamoDBClientBuilder.standard().withCredentials(DefaultAWSCredentialsProviderChain.getInstance())).withRegion(Regions.US_WEST_2)).build()));
    }

    /**
     * This method handles the incoming request by persisting a new player
     * with the provided player username and handicap from the request.
     * <p>
     * It then returns the newly created player.
     * <p>
     * If the provided player name has invalid characters, throws an
     * InvalidAttributeValueException
     *
     * @param createPlayerRequest request object containing the players name and handicap
     *                              associated with it
     * @return createPlayerResult result object containing the API defined {@link PlayerModel}
     */
    @Override
    public CreatePlayerResult handleRequest(final CreatePlayerRequest createPlayerRequest, Context context) {
        //log.info("Received CreatePlayerRequest {}", createPlayerRequest);
        if(!HandicapServiceUtils.isValidString(createPlayerRequest.getUsername()) || createPlayerRequest.getUsername().contains("\"")
                || createPlayerRequest.getUsername().contains("'")
                || createPlayerRequest.getUsername().contains("\\")){
            try {
                throw new InvalidAttributeValueException();
            } catch (InvalidAttributeValueException e) {
                throw new RuntimeException(e);
            }
        }

        Player player = new Player();


        player.setUsername(createPlayerRequest.getUsername());
        player.setEmail(createPlayerRequest.getEmail());
        if(createPlayerRequest.getRounds()!=null) {
            // changed list to arraylist below
            player.setRounds(new ArrayList<Rounds>(createPlayerRequest.getRounds()));
        }else{
            throw new RoundNotFoundException();
        }
        // handicap calculated here
        player.setHandicap(0);
        playerDao.savePlayer(player);
        PlayerModel playerModel = new ModelConverter().toPlayerModel(player);


        return CreatePlayerResult.builder()
                .withPlayer(new ModelConverter().toPlayerModel(player))
                .build();
    }
// ide told me i have to implement this or declare abstract
//    @Override
//    public CreatePlayerResult handleRequest(CreatePlayerRequest input, com.amazonaws.services.lambda.runtime.Context context) {
//        return null;
//    }
}