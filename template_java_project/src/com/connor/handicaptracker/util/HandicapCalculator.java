package com.connor.handicaptracker.util;

import com.connor.handicaptracker.dao.models.Course;
import com.connor.handicaptracker.dao.models.Player;
import com.connor.handicaptracker.dao.models.Rounds;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HandicapCalculator {
    private static final double HANDICAP_INDEX_FACTOR = 0.96;
    //private List<Rounds> rounds;
    //private Player player;
    //private Course course;


    public static double calculateHandicapIndex(List<Rounds> scores) {

        if (scores.size() < 20) {
            throw new IllegalArgumentException("Insufficient scores provided. Minimum of 20 scores required.");
        }

        // Sort the scores in ascending order
        Collections.sort(scores);
        // Ensure that the list has at least 10 scores
        int numScores = Math.min(scores.size(), 10);
        // Get the top 10 lowest scores
        List<Rounds> top10LowestScores = new ArrayList<>(scores.subList(0, numScores));

        // Calculate the average differential score
        double averageDifferentialScore = 0.0;
        for(Rounds score: top10LowestScores) {
            double differential = score.getScore() - score.getCourse().getRating();
            // add 10 diffs and divide by 10
            averageDifferentialScore += differential;

        }
        averageDifferentialScore /= numScores;
        //multiply avg by .96
        return averageDifferentialScore * HANDICAP_INDEX_FACTOR;
        //handicap will be returned
    }

    public static double calculateCourseHandicap(double handicapIndex, double slope, double rating) {
        return (handicapIndex * slope) / 113 + rating;
    }
}
