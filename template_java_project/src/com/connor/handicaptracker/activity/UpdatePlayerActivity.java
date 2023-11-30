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
import com.connor.handicaptracker.dao.models.Rounds;
import com.connor.handicaptracker.exceptions.RoundNotFoundException;
import com.connor.handicaptracker.models.PlayerModel;
import com.connor.handicaptracker.models.requests.CreatePlayerRequest;
import com.connor.handicaptracker.models.requests.UpdatePlayerRequest;
import com.connor.handicaptracker.models.results.CreatePlayerResult;
import com.connor.handicaptracker.models.results.UpdatePlayerResult;
import com.connor.handicaptracker.util.HandicapServiceUtils;

import javax.inject.Inject;
import javax.management.InvalidAttributeValueException;
import java.util.ArrayList;


    public class UpdatePlayerActivity implements RequestHandler<UpdatePlayerRequest, UpdatePlayerResult> {

        private final PlayerDao playerDao;

        /**
         * Instantiates a new CreatePlayerActivity object.
         *
         * @param playerDao PlayerDao to access the players table.
         */
        @Inject
        public UpdatePlayerActivity(PlayerDao playerDao) {
            this.playerDao = playerDao;
        }

        public UpdatePlayerActivity() {
            //playerDao = new PlayerDao(new DynamoDBMapper(DynamoDbClientProvider.getDynamoDBClient(Regions.US_WEST_2)));
            this.playerDao = new PlayerDao(new DynamoDBMapper((AmazonDynamoDB)((AmazonDynamoDBClientBuilder)((AmazonDynamoDBClientBuilder)AmazonDynamoDBClientBuilder.standard().withCredentials(DefaultAWSCredentialsProviderChain.getInstance())).withRegion(Regions.US_WEST_2)).build()));
        }

        /**
         * This method handles the incoming request by updating a player
         * with the provided player username and handicap from the request.
         * <p>
         * It then returns the newly updated player.
         * <p>
         * If the provided player name has invalid characters, throws an
         * InvalidAttributeValueException
         *
         * @param updatePlayerRequest request object
         * @return UpdatePlayerResult result object containing the API defined {@link PlayerModel}
         */
        @Override
        public UpdatePlayerResult handleRequest(final UpdatePlayerRequest updatePlayerRequest, Context context) {
            //log.info("Received CreatePlayerRequest {}", createPlayerRequest);
            if(!HandicapServiceUtils.isValidString(updatePlayerRequest.getUsername()) || updatePlayerRequest.getUsername().contains("\"")
                    || updatePlayerRequest.getUsername().contains("'")
                    || updatePlayerRequest.getUsername().contains("\\")){
                try {
                    throw new InvalidAttributeValueException();
                } catch (InvalidAttributeValueException e) {
                    throw new RuntimeException(e);
                }
            }

            Player player = new Player();


            player.setUsername(updatePlayerRequest.getUsername());
            player.setEmail(updatePlayerRequest.getEmail());
            if(updatePlayerRequest.getRounds()!=null) {
                // changed list to arraylist below

                player.setRounds(new ArrayList<Rounds>(updatePlayerRequest.getRounds()));
            }else{
                throw new RoundNotFoundException();
            }
            // handicap calculated here
            // see HandicapCalculator.java
            player.setHandicap(0);
            playerDao.savePlayer(player);
            PlayerModel playerModel = new ModelConverter().toPlayerModel(player);


            return UpdatePlayerResult.builder()
                    .withPlayer(new ModelConverter().toPlayerModel(player))
                    .build();
        }

}
