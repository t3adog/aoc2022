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
        playTheGame(monkeyList, 20, BigInteger.valueOf(3));
        List<Long> sortedMonkeyInspectedCountList = monkeyList.stream().map(monkey -> monkey.getInspectCount()).sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        return BigInteger.valueOf(sortedMonkeyInspectedCountList.get(0)).multiply(BigInteger.valueOf(sortedMonkeyInspectedCountList.get(1)));
    }


    public BigInteger partTwo(List<String> input) {
        List<Monkey> monkeyList = parseMonkeys(input);
        playTheGame(monkeyList, 10000, null);
        List<Long> sortedMonkeyInspectedCountList = monkeyList.stream().map(monkey -> monkey.getInspectCount()).sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        return BigInteger.valueOf(sortedMonkeyInspectedCountList.get(0)).multiply(BigInteger.valueOf(sortedMonkeyInspectedCountList.get(1)));
    }

    private void playTheGame(List<Monkey> monkeys, int rounds, BigInteger decraseWorriedLevel) {
        for (int round = 0; round < rounds; round++) {
            System.out.println(round);
            for (Monkey monkey : monkeys) {
                for (int i = 0; i < monkey.getItems().size(); i++) {
                    BigInteger item = monkey.getItems().get(i);
                    BigInteger incrementValue = monkey.getIncrementValue() == null ? item : monkey.getIncrementValue();
                    switch (monkey.getIncrementOperation()) {
                        case sum: {
                            item = item.add(incrementValue);
                            break;
                        }
                        case milti: {
                            item = item.multiply(incrementValue);
                            break;
                        }
                    }
                    if (decraseWorriedLevel != null) {
                        item = item.divide(decraseWorriedLevel);
                    }


                    if (item.remainder(monkey.getDivisibleValue()).equals(BigInteger.ZERO)) {
                        monkeys.get(monkey.getMonkeyTrueIndex()).getItems().add(item);
                    } else {
                        monkeys.get(monkey.getMonkeyFalseIndex()).getItems().add(item);
                    }
                    monkey.setInspectCount(monkey.getInspectCount() + 1);
                }
                monkey.getItems().clear();
            }
        }
        System.out.println("~~~~~~~~~~");
        for (Monkey monkey : monkeys) {
            System.out.println(monkey.getInspectCount());
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
