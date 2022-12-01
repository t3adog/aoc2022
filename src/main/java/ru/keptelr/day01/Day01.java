package ru.keptelr.day01;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Day01 {

    private List<Elve> parseElves(List<String> input) {
        List<Elve> elves = new ArrayList<>();

        Elve tmpElve = new Elve();
        for (String str : input) {
            if (str.length() == 0) {
                elves.add(tmpElve);
                tmpElve = new Elve();
            } else {
                tmpElve.setCalories(tmpElve.getCalories() + Long.parseLong(str));
            }
        }
        elves.add(tmpElve);

        return elves;
    }

    public Long partOne(List<String> input) {
        return parseElves(input)
                .stream()
                .map(Elve::getCalories)
                .max(Comparator.naturalOrder())
                .get();
    }

    public Long partTwo(List<String> input) {

        return parseElves(input).stream()
                .map(Elve::getCalories)
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList())
                .subList(0, 3)
                .stream()
                .mapToLong(Long::longValue)
                .sum();
    }

}
