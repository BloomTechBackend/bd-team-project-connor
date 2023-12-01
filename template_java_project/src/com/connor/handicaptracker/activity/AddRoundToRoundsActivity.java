package com.connor.handicaptracker.activity;

import com.amazonaws.auth.DefaultAWSCredentialsProviderChain;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.connor.handicaptracker.converter.ModelConverter;
import com.connor.handicaptracker.dao.PlayerDao;
import com.connor.handicaptracker.dao.RoundsDao;
import com.connor.handicaptracker.dao.models.Player;
import com.connor.handicaptracker.dao.models.Rounds;
import com.connor.handicaptracker.exceptions.PlayerNotFoundException;
import com.connor.handicaptracker.exceptions.RoundNotFoundException;
import com.connor.handicaptracker.models.RoundsModel;
import com.connor.handicaptracker.models.requests.AddRoundToRoundsRequest;
import com.connor.handicaptracker.models.requests.CreatePlayerRequest;
import com.connor.handicaptracker.models.results.AddRoundToRoundsResult;
import com.connor.handicaptracker.models.results.CreatePlayerResult;
import com.connor.handicaptracker.util.HandicapCalculator;

import javax.inject.Inject;
import javax.naming.Context;
import java.util.ArrayList;
import java.util.List;

public class AddRoundToRoundsActivity implements RequestHandler<AddRoundToRoundsRequest, AddRoundToRoundsResult> {
    private final PlayerDao playerDao;
    private final RoundsDao roundsDao;

    @Inject
    public AddRoundToRoundsActivity(PlayerDao playerDao, RoundsDao roundsDao) {
        this.playerDao = playerDao;
        this.roundsDao = roundsDao;
    }

    public AddRoundToRoundsActivity() {
        //playerDao = new PlayerDao(new DynamoDBMapper(DynamoDbClientProvider.getDynamoDBClient(Regions.US_WEST_2)));
        this.playerDao = new PlayerDao(new DynamoDBMapper((AmazonDynamoDB)((AmazonDynamoDBClientBuilder)((AmazonDynamoDBClientBuilder)AmazonDynamoDBClientBuilder.standard().withCredentials(DefaultAWSCredentialsProviderChain.getInstance())).withRegion(Regions.US_WEST_2)).build()));
        this.roundsDao = new RoundsDao(new DynamoDBMapper((AmazonDynamoDB)((AmazonDynamoDBClientBuilder)((AmazonDynamoDBClientBuilder)AmazonDynamoDBClientBuilder.standard().withCredentials(DefaultAWSCredentialsProviderChain.getInstance())).withRegion(Regions.US_WEST_2)).build()));
    }


    public void addRound(Rounds round) {
        DynamoDBMapper mapper = new DynamoDBMapper((AmazonDynamoDB)((AmazonDynamoDBClientBuilder)((AmazonDynamoDBClientBuilder)AmazonDynamoDBClientBuilder.standard().withCredentials(DefaultAWSCredentialsProviderChain.getInstance())).withRegion(Regions.US_WEST_2)).build());
        mapper.save(round);
    }
//    public AddRoundToRoundsResult handleRequest(final AddRoundToRoundsRequest addRoundToRoundsRequest, Context context){
//        // retrieve player
//        Player player = playerDao.getPlayer(addRoundToRoundsRequest.getDate());
//        if (player == null) {
//            throw new PlayerNotFoundException();
//        }
//        //retrieve rounds
//        //Rounds rounds = roundsDao.getRounds()
//        List<Rounds> rounds = player.getRounds();
//        // round to add
//        Rounds round = roundsDao.getRound(addRoundToRoundsRequest.getDate(), addRoundToRoundsRequest.getScore());
//        if (round == null) {
//            throw new RoundNotFoundException();
//        }
//        // add round to rounds list
//        rounds.add(round);
//        player.setRounds(rounds);
//        //updated handicap index
//        HandicapCalculator.calculateHandicapIndex(rounds);
//        // persist
//        playerDao.savePlayer(player);
//        // convert to roundModels and add to roundsModelList
//        List<RoundsModel> roundsModelList = new ArrayList<>();
//        for (Rounds newRound : rounds) {
//            RoundsModel roundsModel = new ModelConverter().toRoundsModel(newRound);
//            roundsModelList.add(roundsModel);
//        }
//
//        return AddRoundToRoundsResult.builder()
//                  .withRoundsModel(roundsModelList)
//                  .build();
//        }

    @Override
    public AddRoundToRoundsResult handleRequest(AddRoundToRoundsRequest addRoundToRoundsRequest, com.amazonaws.services.lambda.runtime.Context context) {
        // retrieve player
        Player player = playerDao.getPlayer(addRoundToRoundsRequest.getDate());
        if (player == null) {
            throw new PlayerNotFoundException();
        }
        //retrieve rounds
        //Rounds rounds = roundsDao.getRounds()
        List<Rounds> rounds = player.getRounds();
        // round to add
        Rounds round = roundsDao.getRound(addRoundToRoundsRequest.getDate(), addRoundToRoundsRequest.getScore());
        if (round == null) {
            throw new RoundNotFoundException();
        }
        // add round to rounds list
        rounds.add(round);
        player.setRounds(rounds);
        //updated handicap index
        HandicapCalculator.calculateHandicapIndex(rounds);
        // persist
        playerDao.savePlayer(player);
        // convert to roundModels and add to roundsModelList
        List<RoundsModel> roundsModelList = new ArrayList<>();
        for (Rounds newRound : rounds) {
            RoundsModel roundsModel = new ModelConverter().toRoundsModel(newRound);
            roundsModelList.add(roundsModel);
        }

        return AddRoundToRoundsResult.builder()
                .withRoundsModel(roundsModelList)
                .build();
    }
}
