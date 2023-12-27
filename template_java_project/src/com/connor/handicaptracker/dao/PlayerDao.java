package com.connor.handicaptracker.dao;


import com.connor.handicaptracker.dao.models.Player;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.connor.handicaptracker.exceptions.PlayerNotFoundException;

import javax.inject.Inject;

public class PlayerDao {
    private final DynamoDBMapper dynamoDbMapper;

    /**
     * Instantiates a PlayerDao object.
     *
     * @param dynamoDbMapper the {@link DynamoDBMapper} used to interact with the playlists table
     */
    @Inject
    public PlayerDao(DynamoDBMapper dynamoDbMapper) {
        this.dynamoDbMapper = dynamoDbMapper;
    }

    /**
     * Returns the {@link Player} corresponding to the specified id.
     *
     * @param username    the Player Username

     * @return the stored Playlist, or null if none was found.
     */
    public Player getPlayer(String username) {
        Player player = this.dynamoDbMapper.load(Player.class, username);

        if (player == null) {
            throw new PlayerNotFoundException("Could not find player with username " + username);
        }

        return player;
    }

    public Player savePlayer(Player player) {
        dynamoDbMapper.save(player);
        return player;
    }
}




