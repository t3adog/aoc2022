package ru.keptelr.day11;

import org.apache.commons.lang3.Range;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Day11 {

    List<Monkey> parseMonkeys(List<String> input) {
        List<Monkey> monkeyList = new ArrayList<>();
        for (int i = 0; i < input.size(); i++) {
            String line = input.get(i);
            if (line.startsWith("Monkey")) {
                monkeyList.add(Monkey.from(input.subList(i, i + 6)));
            }
        }
        validateMonkeyList(monkeyList);
        return monkeyList;
    }

    public Integer partOne(List<String> input) {
        List<Monkey> monkeyList = parseMonkeys(input);
        for (int round = 0; round < 20; round++) {
            List<Integer> items = new ArrayList<>();
            for (Monkey monkey : monkeyList) {
                for (int i = 0; i < monkey.getItems().size(); i++) {
                    Integer item = monkey.getItems().get(i);
                    int incrementValue = monkey.getIncrementValue() == null ? item : monkey.getIncrementValue();
                    switch (monkey.getIncrementOperation()) {
                        case sum: {

                            item = item + incrementValue;
                            break;
                        }
                        case milti: {
                            item = item * incrementValue;
                            break;
                        }
                    }
                    item = item / 3;

                    if (item % monkey.getDivisibleValue().doubleValue() == 0) {
                        monkeyList.get(monkey.getMonkeyTrueIndex()).getItems().add(item);
                    } else {
                        monkeyList.get(monkey.getMonkeyFalseIndex()).getItems().add(item);
                    }
                    monkey.setInspectCount(monkey.getInspectCount() + 1);
                }
                monkey.setItems(new LinkedList<>());
            }
        }
        List<Integer> sortedMonkeyInspectedCountList = monkeyList.stream().map(monkey -> monkey.getInspectCount()).sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        return sortedMonkeyInspectedCountList.get(0) * sortedMonkeyInspectedCountList.get(1);
    }


    public int partTwo(List<String> input) {
        return 0;
    }

    private void validateMonkeyList(List<Monkey> monkeyList) {
        Range<Integer> monkeyListRange = Range.between(0, monkeyList.size());
        for (Monkey monkey : monkeyList) {
            if (!monkeyListRange.contains(monkey.getMonkeyTrueIndex())
                    || !monkeyListRange.contains(monkey.getMonkeyFalseIndex())) {
                throw new RuntimeException("");
            }
        }
    }
}
