package com.connor.handicaptracker.models.requests;

import com.amazonaws.internal.config.Builder;

import java.util.Objects;

public class GetHandicapRequest {
    private String username;
    private double handicap;

    public GetHandicapRequest(){

    }

    public GetHandicapRequest(Builder builder) {
        this.username = builder.username;
    }

    public GetHandicapRequest(String username, double handicap) {
        this.username = username;
        this.handicap = handicap;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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
        GetHandicapRequest that = (GetHandicapRequest) o;
        return Double.compare(that.handicap, handicap) == 0 && Objects.equals(username, that.username);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, handicap);
    }

    @Override
    public String toString() {
        return "GetHandicapRequest{" +
                "username='" + username + '\'' +
                ", handicap=" + handicap +
                '}';
    }

    public static GetHandicapRequest.Builder builder() { return new GetHandicapRequest.Builder(); }

    public static final class Builder {
        private String username;

        private double handicap;

        private Builder() {

        }

        public GetHandicapRequest.Builder withUsername(String usernameToUse) {
            this.username = usernameToUse;
            return this;
        }

        public GetHandicapRequest.Builder withHandicap(double handicapToUse) {
            this.handicap = handicapToUse;
            return this;
        }

        public GetHandicapRequest build() {
            return new GetHandicapRequest(this);
        }
    }
}
