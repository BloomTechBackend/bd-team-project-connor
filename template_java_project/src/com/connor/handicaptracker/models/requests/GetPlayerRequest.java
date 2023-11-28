package com.connor.handicaptracker.models.requests;

import com.connor.handicaptracker.dao.models.Rounds;

import java.util.List;
import java.util.Objects;
public class GetPlayerRequest {
    private String username;
    private String email;
    private List<Rounds> rounds;
    private double handicap;

//    public GetPlayerRequest(String username) {
//        this.username = username;
//    }

    public GetPlayerRequest(){

    }

    public GetPlayerRequest(Builder builder) {
        this.username = builder.username;
        this.email = builder.email;
        this.rounds = builder.rounds;
        this.handicap = builder.handicap;
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
        GetPlayerRequest that = (GetPlayerRequest) o;
        return Objects.equals(username, that.username);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username);
    }

    @Override
    public String toString() {
        return "GetPlayerRequest{" +
                "username='" + username + '\'' +
                '}';
    }

    public static GetPlayerRequest.Builder builder() { return new GetPlayerRequest.Builder(); }

    public static final class Builder {
        private String username;
        private String email;
        private double handicap;
        private List<Rounds> rounds;

        private Builder() {

        }

        public GetPlayerRequest.Builder withUsername(String usernameToUse) {
            this.username = usernameToUse;
            return this;
        }

        public GetPlayerRequest.Builder withEmail(String emailToUse) {
            this.email = emailToUse;
            return this;
        }



        public GetPlayerRequest.Builder withHandicap(double handicapToUse) {
            this.handicap = handicapToUse;
            return this;
        }

        public GetPlayerRequest.Builder withRounds(List<Rounds> roundsToUse) {
            this.rounds = roundsToUse;
            return this;
        }

        public GetPlayerRequest build() { return new GetPlayerRequest(this); }

    }
}

