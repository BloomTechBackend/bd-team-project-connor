package com.connor.handicaptracker.models.requests;

import com.connor.handicaptracker.dao.models.Handicap;
import com.connor.handicaptracker.dao.models.Player;
import com.connor.handicaptracker.dao.models.Rounds;

import java.util.List;
import java.util.Objects;

public class CreatePlayerRequest {
    private String username;
    private double handicap;

    private String email;
    private List<Rounds> rounds;

    public CreatePlayerRequest(){

    }



    public CreatePlayerRequest(String username,String email, double handicap, List<Rounds> rounds) {
        this.username = username;
        this.email = email;
        this.handicap = handicap;
        this.rounds = rounds;
    }

    public CreatePlayerRequest(Builder builder) {
        this.username = builder.username;
        this.email = builder.email;
        this.handicap = builder.handicap;
        this.rounds = builder.rounds;
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

    public double getHandicap() {
        return handicap;
    }

    public void setHandicap(int handicap) {
        this.handicap = handicap;
    }

    public List<Rounds> getRounds() {
        return rounds;
    }

    public void setRounds(List<Rounds> rounds) {
        this.rounds = rounds;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CreatePlayerRequest that = (CreatePlayerRequest) o;
        return username.equals(that.username) && (handicap == that.handicap) && rounds.equals(that.rounds);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, handicap, rounds);
    }

    @Override
    public String toString() {
        return "CreatePlayerRequest{" +
                "username=" + username + '\'' +
                ", handicap=" + handicap + '\'' +
                ", rounds=" + rounds +
                '}';
    }

    public static Builder builder() { return new Builder(); }

    public static final class Builder {
        private String username;
        private String email;
        private double handicap;
        private List<Rounds> rounds;

        private Builder() {

        }

        public Builder withUsername(String usernameToUse) {
            this.username = usernameToUse;
            return this;
        }

        public Builder withEmail(String emailToUse) {
            this.email = emailToUse;
            return this;
        }



        public Builder withHandicap(double handicapToUse) {
            this.handicap = handicapToUse;
            return this;
        }

        public Builder withRounds(List<Rounds> roundsToUse) {
            this.rounds = roundsToUse;
            return this;
        }

        public CreatePlayerRequest build() { return new CreatePlayerRequest(this); }
    }
}
