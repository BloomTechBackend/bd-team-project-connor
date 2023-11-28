package com.connor.handicaptracker.models.results;

import com.connor.handicaptracker.models.PlayerModel;

public class GetPlayerResult {
    private PlayerModel player;

    public GetPlayerResult(Builder builder) {
        this.player = builder.player;
    }

    public PlayerModel getPlayer() {
        return player;
    }

    public void setPlayer(PlayerModel player) {
        this.player = player;
    }

    public static Builder builder() {return new Builder();}

    public static final class Builder {
        private PlayerModel player;

        public Builder withPlayer(PlayerModel playerToUse) {
            this.player = playerToUse;
            return this;
        }

        public GetPlayerResult build() {return new GetPlayerResult(this);}
    }
}
