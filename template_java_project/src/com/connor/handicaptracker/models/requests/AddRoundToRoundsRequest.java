package com.connor.handicaptracker.models.requests;

import com.amazonaws.internal.config.Builder;
import com.connor.handicaptracker.models.results.AddRoundToRoundsResult;

import java.util.Objects;

public class AddRoundToRoundsRequest {
    private String date;
    private int score;

    public AddRoundToRoundsRequest() {

    }

    public AddRoundToRoundsRequest(String date, int score) {
        this.date = date;
        this.score = score;
    }

    public AddRoundToRoundsRequest(Builder builder) {
        this.date = builder.date;
        this.score = builder.score;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AddRoundToRoundsRequest that = (AddRoundToRoundsRequest) o;
        return score == that.score && Objects.equals(date, that.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(date, score);
    }

    @Override
    public String toString() {
        return "AddRoundToRoundsRequest{" +
                "date='" + date + '\'' +
                ", score=" + score +
                '}';
    }

    public static Builder builder() {return new Builder();}

    public static final class Builder {
        private String date;
        private int score;

        private Builder() {

        }

        public Builder withDate(String dateToUse) {
            this.date = dateToUse;
            return this;
        }

        public Builder withScore(int scoreToUse) {
            this.score = scoreToUse;
            return this;
        }

        public AddRoundToRoundsRequest build() {
            return new AddRoundToRoundsRequest(this); }
    }


}
