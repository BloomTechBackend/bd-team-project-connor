package com.connor.handicaptracker.models.requests;

import com.connor.handicaptracker.dao.models.Rounds;

import java.util.List;
import java.util.Objects;

public class UpdatePlayerRequest {
    private String username;
    private double handicap;

    private String email;
    private List<Rounds> rounds;

    public UpdatePlayerRequest(){

    }



    public UpdatePlayerRequest(String username,String email, double handicap, List<Rounds> rounds) {
        this.username = username;
        this.email = email;
        this.handicap = handicap;
        this.rounds = rounds;
    }

    public UpdatePlayerRequest(UpdatePlayerRequest.Builder builder) {
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
        UpdatePlayerRequest that = (UpdatePlayerRequest) o;
        return username.equals(that.username) && (handicap == that.handicap) && rounds.equals(that.rounds);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, handicap, rounds);
    }

    @Override
    public String toString() {
        return "UpdatePlayerRequest{" +
                "username=" + username + '\'' +
                ", handicap=" + handicap + '\'' +
                ", rounds=" + rounds +
                '}';
    }

    public static UpdatePlayerRequest.Builder builder() { return new UpdatePlayerRequest.Builder(); }

    public static final class Builder {
        private String username;
        private String email;
        private double handicap;
        private List<Rounds> rounds;

        private Builder() {

        }

        public UpdatePlayerRequest.Builder withUsername(String usernameToUse) {
            this.username = usernameToUse;
            return this;
        }

        public UpdatePlayerRequest.Builder withEmail(String emailToUse) {
            this.email = emailToUse;
            return this;
        }



        public UpdatePlayerRequest.Builder withHandicap(double handicapToUse) {
            this.handicap = handicapToUse;
            return this;
        }

        public UpdatePlayerRequest.Builder withRounds(List<Rounds> roundsToUse) {
            this.rounds = roundsToUse;
            return this;
        }

        public UpdatePlayerRequest build() { return new UpdatePlayerRequest(this); }
    }
}
