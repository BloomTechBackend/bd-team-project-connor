package com.connor.handicaptracker.models.requests;

import com.amazonaws.internal.config.Builder;
import com.connor.handicaptracker.dao.models.Course;
import com.connor.handicaptracker.models.results.AddRoundToRoundsResult;

import java.util.Objects;

public class AddRoundToRoundsRequest {
    private String username;
    private String date;
    private double score;
    private Course course;

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public AddRoundToRoundsRequest() {

    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public AddRoundToRoundsRequest(String username, String date, double score) {
        this.username = username;
        this.date = date;
        this.score = score;
    }

    public AddRoundToRoundsRequest(Builder builder) {
        this.username = builder.username;
        this.date = builder.date;
        this.score = builder.score;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
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
        private String username;
        private String date;
        private double score;

        private Builder() {

        }

        public Builder withDate(String dateToUse) {
            this.date = dateToUse;
            return this;
        }

        public Builder withScore(double scoreToUse) {
            this.score = scoreToUse;
            return this;
        }

        public AddRoundToRoundsRequest build() {
            return new AddRoundToRoundsRequest(this); }
    }


}
