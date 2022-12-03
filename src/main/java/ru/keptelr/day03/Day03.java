package ru.keptelr.day03;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Day03 {

    private PriorityCounter priorityCounter = new PriorityCounter();

    public int partOne(List<String> input) {
        List<Rucksack> rucksacks = input.stream().map(Rucksack::new).collect(Collectors.toList());

        int priorityCount = 0;
        for (Rucksack rucksack : rucksacks) {
            priorityCount += priorityCounter.getPriority(rucksack.findDuplicates());
        }
        return priorityCount;
    }

    public int partTwo(List<String> input) {
        List<Rucksack> rucksacks = input.stream().map(Rucksack::new).collect(Collectors.toList());

        int priorityCount = 0;
        for (int i = 0; i < rucksacks.size(); i += 3) {
            priorityCount += priorityCounter.getPriority(findDuplicates(rucksacks.subList(i, i + 3)));
        }

        return priorityCount;
    }

    private Set<Character> findDuplicates(List<Rucksack> rucksacks) {
        if (rucksacks.size() != 3) {
            throw new RuntimeException("whats wrong with you?"); // with me of course
        }
        Set<Character> duplicates = new HashSet<>();
        for (Character character : rucksacks.get(0).getFullContent()) {
            if (rucksacks.get(1).getFullContent().contains(character)
                    && rucksacks.get(2).getFullContent().contains(character)) {
                duplicates.add(character);
            }
        }
        return duplicates;
    }
}
