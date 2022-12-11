package ru.keptelr.day11;

import org.apache.commons.lang3.Range;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Comparator;
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

    public BigInteger partOne(List<String> input) {
        List<Monkey> monkeyList = parseMonkeys(input);
        playTheGame(monkeyList, 20, 3L);
        List<Long> sortedMonkeyInspectedCountList = monkeyList.stream().map(monkey -> monkey.getInspectCount()).sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        return BigInteger.valueOf(sortedMonkeyInspectedCountList.get(0)).multiply(BigInteger.valueOf(sortedMonkeyInspectedCountList.get(1)));
    }


    public BigInteger partTwo(List<String> input) {
        List<Monkey> monkeyList = parseMonkeys(input);
        playTheGame(monkeyList, 10000, null);
        List<Long> sortedMonkeyInspectedCountList = monkeyList.stream().map(monkey -> monkey.getInspectCount()).sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        return BigInteger.valueOf(sortedMonkeyInspectedCountList.get(0)).multiply(BigInteger.valueOf(sortedMonkeyInspectedCountList.get(1)));
    }

    private void playTheGame(List<Monkey> monkeys, int rounds, Long decraseWorriedLevel) {
        // stole it on reddit for part 2
        int superModulo = monkeys.stream().mapToInt(Monkey::getDivisibleValue).reduce(1, (a, b) -> {
            return a * b;
        });
        for (int round = 0; round < rounds; round++) {
            for (Monkey monkey : monkeys) {
                monkey.reduceItems(superModulo);
                for (int i = 0; i < monkey.getItems().size(); i++) {
                    Long item = monkey.getItems().get(i);
                    Long incrementValue = monkey.getIncrementValue() == null ? item : monkey.getIncrementValue();
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
                    if (decraseWorriedLevel != null) {
                        item = item / decraseWorriedLevel;
                    }

                    if (item % monkey.getDivisibleValue() == 0) {
                        monkeys.get(monkey.getMonkeyTrueIndex()).getItems().add(item);
                    } else {
                        monkeys.get(monkey.getMonkeyFalseIndex()).getItems().add(item);
                    }
                    monkey.setInspectCount(monkey.getInspectCount() + 1);
                }
                monkey.getItems().clear();
            }
        }
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
