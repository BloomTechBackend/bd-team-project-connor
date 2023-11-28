package com.connor.handicaptracker.models;


import com.amazonaws.internal.config.Builder;
import com.connor.handicaptracker.models.results.GetHandicapResult;
import com.connor.handicaptracker.models.results.GetPlayerResult;

import java.util.Objects;

public class HandicapModel {
      private String username;
      private double handicapIndex;

      public HandicapModel() {

      }

      public HandicapModel(Builder builder) {
          this.username = builder.username;
          this.handicapIndex = builder.handicapIndex;
      }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public double getHandicapIndex() {
        return handicapIndex;
    }

    public void setHandicapIndex(double handicapIndex) {
        this.handicapIndex = handicapIndex;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HandicapModel that = (HandicapModel) o;
        return handicapIndex == that.handicapIndex && Objects.equals(username, that.username);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, handicapIndex);
    }

    @Override
    public String toString() {
        return "HandicapModel{" +
                "username='" + username + '\'' +
                ", handicapIndex=" + handicapIndex +
                '}';
    }

    public static Builder builder() {
          return new Builder();
    }

    public static final class Builder {
          private String username;
          private double handicapIndex;

          public Builder withUsername(String usernameToUse) {
              this.username = usernameToUse;
              return this;
          }

          public Builder withHandicapIndex(double handicapIndexToUse) {
              this.handicapIndex = handicapIndexToUse;
              return this;
          }

          public HandicapModel build() {
              return new HandicapModel(this);
          }

    }
}

