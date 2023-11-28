package com.connor.handicaptracker.converter;

import com.connor.handicaptracker.dao.models.Player;
import com.connor.handicaptracker.dao.models.Rounds;
import com.connor.handicaptracker.models.PlayerModel;
import com.connor.handicaptracker.models.RoundsModel;

public class ModelConverter {
    /**
     * Converts a provided {@link Player} into a {@link PlayerModel} representation.
     * @param player the player to convert
     * @return the converted player
     */


    public PlayerModel toPlayerModel(Player player) {
//        List<String> tags;
//        if (playlist.getTags()==null) {
//            tags = null;
//        } else {
//            tags = new ArrayList<>(playlist.getTags());
//        }


        return PlayerModel.builder()
                .withUsername(player.getUsername())
                .withEmail(player.getEmail())
                .withRounds(player.getRounds())
                .withHandicap(player.getHandicap())
                .build();
    }

    public RoundsModel toRoundsModel(Rounds round) {


        return RoundsModel.builder()
                .withDate(round.getDate())
                .withScore(round.getScore())
                .build();
    }
}
