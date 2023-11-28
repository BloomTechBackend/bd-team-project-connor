package com.connor.handicaptracker.models.results;

import com.connor.handicaptracker.dao.models.Rounds;
import com.connor.handicaptracker.models.RoundsModel;

import java.util.List;

public class AddRoundToRoundsResult {
    private List<RoundsModel> roundsModel;

    public AddRoundToRoundsResult(Builder builder) {
        this.roundsModel = builder.roundsModel;
    }

    public List<RoundsModel> getRoundsModel() {
        return roundsModel;
    }

    public void setRounds(List<RoundsModel> roundsModel) {
        this.roundsModel = roundsModel;
    }

    public static Builder builder() {return new Builder();}

    public static final class Builder {
        private List<RoundsModel> roundsModel;

        public Builder withRoundsModel(List<RoundsModel> roundsModelToUse) {
            this.roundsModel = roundsModelToUse;
            return this;
        }

        public AddRoundToRoundsResult build() {
            return new AddRoundToRoundsResult(this);
         }
        }
}
