package ru.keptelr.day11;

import lombok.Data;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class Monkey {

    private Integer id;
    private LinkedList<Integer> items;
    private Operation incrementOperation;
    private Integer incrementValue;
    private Integer divisibleValue;

    private Integer monkeyTrueIndex;
    private Integer monkeyFalseIndex;

    private Integer inspectCount;

    public static Monkey from(List<String> input) {
        Monkey monkey = new Monkey();
        monkey.setId(Integer.parseInt(input.get(0).replaceAll("Monkey ", "").replaceAll(":", "")));
        monkey.setItems(new LinkedList<>(Arrays.stream(input.get(1).replaceAll("  Starting items: ", "").split(", ")).map(Integer::parseInt).collect(Collectors.toList())));

        String[] operation =  input.get(2).replaceAll("  Operation: new = old ", "").split(" ");
        monkey.setIncrementOperation(operation[0].equals("*") ? Operation.milti : Operation.sum);
        monkey.setIncrementValue(operation[1].equals("old") ? null : Integer.parseInt(operation[1]));
        monkey.setDivisibleValue(Integer.parseInt(input.get(3).replaceAll("  Test: divisible by ", "")));

        monkey.setMonkeyTrueIndex(Integer.parseInt(input.get(4).replaceAll("    If true: throw to monkey ", "")));
        monkey.setMonkeyFalseIndex(Integer.parseInt(input.get(5).replaceAll("    If false: throw to monkey ", "")));

        monkey.setInspectCount(0);
        return monkey;
    }

}
