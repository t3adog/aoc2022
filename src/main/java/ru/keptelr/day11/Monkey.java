package ru.keptelr.day11;

import lombok.Data;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class Monkey {

    private Integer id;
    private List<BigInteger> items;
    private Operation incrementOperation;
    private BigInteger incrementValue;
    private BigInteger divisibleValue;

    private Integer monkeyTrueIndex;
    private Integer monkeyFalseIndex;

    private Long inspectCount;

    public static Monkey from(List<String> input) {
        Monkey monkey = new Monkey();
        monkey.setId(Integer.parseInt(input.get(0).replaceAll("Monkey ", "").replaceAll(":", "")));
        monkey.setItems((Arrays.stream(input.get(1).replaceAll("  Starting items: ", "").split(", ")).map(BigInteger::new).collect(Collectors.toList())));

        String[] operation =  input.get(2).replaceAll("  Operation: new = old ", "").split(" ");
        monkey.setIncrementOperation(operation[0].equals("*") ? Operation.milti : Operation.sum);
        monkey.setIncrementValue(operation[1].equals("old") ? null : new BigInteger(operation[1]));
        monkey.setDivisibleValue(new BigInteger(input.get(3).replaceAll("  Test: divisible by ", "")));

        monkey.setMonkeyTrueIndex(Integer.parseInt(input.get(4).replaceAll("    If true: throw to monkey ", "")));
        monkey.setMonkeyFalseIndex(Integer.parseInt(input.get(5).replaceAll("    If false: throw to monkey ", "")));

        monkey.setInspectCount(0L);
        return monkey;
    }

}
