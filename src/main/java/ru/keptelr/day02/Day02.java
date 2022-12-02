package ru.keptelr.day02;

import java.util.List;

public class Day02 {

    public int partOne(List<String> input) {
        int scores = 0;
        for (String str : input) {
            Step he = new Step(str.split(" ")[0]);
            Step me = new Step(str.split(" ")[1]);

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
        }
        return scores;
    }

    public int partTwo(List<String> input) {
        return 0;
    }
}
