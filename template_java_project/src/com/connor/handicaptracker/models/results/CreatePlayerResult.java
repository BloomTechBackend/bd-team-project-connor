package com.connor.handicaptracker.models.results;

import com.connor.handicaptracker.models.HandicapModel;
import com.connor.handicaptracker.models.PlayerModel;

public class CreatePlayerResult {
    private PlayerModel player;

    public CreatePlayerResult(Builder builder) {
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

        public Builder withPlayer(PlayerModel player) {
            this.player = player;
            return this;
        }

        public CreatePlayerResult build() {return new CreatePlayerResult(this);}
    }
}
