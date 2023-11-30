package com.connor.handicaptracker.models.results;

import com.connor.handicaptracker.models.PlayerModel;

public class UpdatePlayerResult {
    private PlayerModel player;

    public UpdatePlayerResult(UpdatePlayerResult.Builder builder) {
        this.player = builder.player;
    }

    public PlayerModel getPlayer() {
        return player;
    }

    public void setPlayer(PlayerModel player) {
        this.player = player;
    }

    public static UpdatePlayerResult.Builder builder() {return new UpdatePlayerResult.Builder();}

    public static final class Builder {
        private PlayerModel player;

        public UpdatePlayerResult.Builder withPlayer(PlayerModel player) {
            this.player = player;
            return this;
        }

        public UpdatePlayerResult build() {return new UpdatePlayerResult(this);}
    }
}
