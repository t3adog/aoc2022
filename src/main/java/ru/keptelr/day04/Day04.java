package ru.keptelr.day04;

import java.util.List;

import org.apache.commons.lang3.Range;

public class Day04 {

    public int partOne(List<String> input) {

        int duplicateCount = 0;
        for (String line : input) {
            String firstSectorStr = line.split(",")[0];
            String secondSectorStr = line.split(",")[1];

            Range<Integer> firstSector = parseSector(firstSectorStr);
            Range<Integer> secondSector = parseSector(secondSectorStr);

            if (firstSector.containsRange(secondSector) || secondSector.containsRange(firstSector)) {
                duplicateCount++;
            }

        }
        return duplicateCount;
    }

    public int partTwo(List<String> input) {

        int duplicateCount = 0;

        for (String line : input) {
            String firstSectorStr = line.split(",")[0];
            String secondSectorStr = line.split(",")[1];

            Range<Integer> firstSector = parseSector(firstSectorStr);
            Range<Integer> secondSector = parseSector(secondSectorStr);

            if (firstSector.isOverlappedBy(secondSector) || secondSector.isOverlappedBy(firstSector)) {
                duplicateCount++;
            }
        }

        return duplicateCount;
    }

    private Range<Integer> parseSector(String input) {
        return Range.between(Integer.parseInt(input.split("-")[0]), Integer.parseInt(input.split("-")[1]));
    }

}
