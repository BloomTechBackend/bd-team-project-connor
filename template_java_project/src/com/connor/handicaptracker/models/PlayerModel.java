package com.connor.handicaptracker.models;

import com.connor.handicaptracker.dao.models.Rounds;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class PlayerModel {
   private String username;
   private String email;
   private List<Rounds> rounds;
   private double handicap;

   public PlayerModel(){

   }

    public PlayerModel(String username, String email, List<Rounds> rounds, double handicap) {
        this.username = username;
        this.email = email;
        this.rounds = rounds;
        this.handicap = handicap;
    }

    public PlayerModel(Builder builder) {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Rounds> getRounds() {
        return rounds;
    }

    public void setRounds(List<Rounds> rounds) {
        this.rounds = rounds;
    }

    public double getHandicap() {
        return handicap;
    }

    public void setHandicap(double handicap) {
        this.handicap = handicap;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlayerModel that = (PlayerModel) o;
        return handicap == that.handicap && Objects.equals(username, that.username) && Objects.equals(email, that.email) && Objects.equals(rounds, that.rounds);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, email, rounds, handicap);
    }

    @Override
    public String toString() {
        return "PlayerModel{" +
                "username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", rounds=" + rounds +
                ", handicap=" + handicap +
                '}';
    }

    public static PlayerModel.Builder builder() {
        return new PlayerModel.Builder();
    }

    public static final class Builder {
        private String username;
        private String email;
        private List<Rounds> rounds;
        private double handicap;

        public PlayerModel.Builder withUsername(String usernameToUse) {
            this.username = usernameToUse;
            return this;
        }
        public PlayerModel.Builder withEmail(String emailToUse) {
            this.email = emailToUse;
            return this;
        }
        public PlayerModel.Builder withRounds(List<Rounds> roundsToUse) {
            this.rounds = roundsToUse;
            return this;
        }


        public PlayerModel.Builder withHandicap(double handicapToUse) {
            this.handicap = handicapToUse;
            return this;
        }

        public PlayerModel build() {
            return new PlayerModel(this);
        }

    }
}
