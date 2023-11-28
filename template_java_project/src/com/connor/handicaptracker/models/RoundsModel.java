package com.connor.handicaptracker.models;

import com.amazonaws.internal.config.Builder;

import java.util.Objects;

public class RoundsModel {
    private String date;
    private int score;

    public RoundsModel() {

    }

    public RoundsModel(Builder builder) {
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
        RoundsModel that = (RoundsModel) o;
        return score == that.score && Objects.equals(date, that.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(date, score);
    }

    @Override
    public String toString() {
        return "RoundsModel{" +
                "date='" + date + '\'' +
                ", score=" + score +
                '}';
    }

    public static Builder builder() { return new Builder();}

    public static final class Builder {
        private String date;
        private int score;

        public Builder withDate(String dateToUse) {
            this.date = dateToUse;
            return this;
        }

        public Builder withScore(int scoreToUse) {
            this.score = scoreToUse;
            return this;
        }

        public RoundsModel build() {
            return new RoundsModel(this);
        }

    }


}
