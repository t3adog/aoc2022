package ru.keptelr.day04;

import java.util.List;

import org.apache.commons.lang3.Range;

public class Day04 {
    public int partOne(List<String> input) {
        // 2-4,6-8

        int duplicateCount = 0;
        for (String line : input) {
            String firstSectorStr = line.split(",")[0];
            String secondSectorStr = line.split(",")[1];

            Range<Integer> firstSector = Range.between(Integer.parseInt(firstSectorStr.split("-")[0]), Integer.parseInt(firstSectorStr.split("-")[1]));
            Range<Integer> secondSector = Range.between(Integer.parseInt(secondSectorStr.split("-")[0]), Integer.parseInt(secondSectorStr.split("-")[1]));
            
            if (firstSector.containsRange(secondSector) || secondSector.containsRange(firstSector)) {
                duplicateCount++;
            }

        }
       return duplicateCount;
    }

    public int partTwo(List<String> input) {
       return 0;
    }

}
