package ru.keptelr.day02;

import java.util.List;
import java.util.Map;

public class Day02 {

    private static final Map<String, Integer> STEP_MAP = Map.of(
            "X", -1,
            "Y", 0,
            "Z", 1);

    private Shape findMyShape(Step he, String status) {
        for (Shape value : Shape.values()) {
            if (new Step(value).compareTo(he) == STEP_MAP.get(status)) {
                return value;
            }
        }
        throw new RuntimeException("what's wrong with you?");
    }

    public int partOne(List<String> input) {
        int scores = 0;
        for (String str : input) {
            Step he = new Step(str.split(" ")[0]);
            Step me = new Step(str.split(" ")[1]);
            scores += calcScores(he, me);           
        }
        return scores;
    }

    public int partTwo(List<String> input) {
        int scores = 0;
        for (String str : input) {
            Step he = new Step(str.split(" ")[0]);
            Step me = new Step(findMyShape(new Step(he.getShape()), str.split(" ")[1]));
            scores += calcScores(he, me); 
        }
        return scores;
    }

    private int calcScores(Step he, Step me) {
        int scores = 0;
        int compare = me.compareTo(he);
            switch (compare) {
                case 0: {
                    scores = scores + 3 + me.getScore();
                    break;
                }
                case 1: {
                    scores = scores + 6 + me.getScore();
                    break;
                }
                case -1: {
                    scores = scores + me.getScore();
                    break;
                }
            }
            return scores;
    }
}
