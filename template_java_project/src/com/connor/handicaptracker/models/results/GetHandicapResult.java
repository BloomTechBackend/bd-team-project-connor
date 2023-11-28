package com.connor.handicaptracker.models.results;

import com.connor.handicaptracker.models.HandicapModel;


public class GetHandicapResult {
    private HandicapModel handicap;

    public GetHandicapResult(Builder builder) {
        this.handicap = builder.handicap;
    }

    public HandicapModel getHandicap() {
        return handicap;
    }

    public void setHandicap(HandicapModel handicap) {
        this.handicap = handicap;
    }

    public static Builder builder() {return new Builder();}

    public static final class Builder {
        private HandicapModel handicap;

        public Builder withHandicap(HandicapModel handicapToUse) {
            this.handicap = handicapToUse;
            return this;
        }

        public GetHandicapResult build() {
            return new GetHandicapResult(this);
        }
    }


}



