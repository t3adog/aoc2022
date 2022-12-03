package ru.keptelr.day03;

import java.util.List;
import java.util.stream.Collectors;

public class Day03 {

   
    public int partOne(List<String> input) {
        List<Rucksack> rucksacks = input.stream().map(Rucksack::new).collect(Collectors.toList());
        return rucksacks.stream().map(Rucksack::getPriority).mapToInt(Integer::intValue).sum();
    }

    public int partTwo(List<String> input) {
        return 0;
    }
}
