package ru.keptelr.day09;

import org.apache.commons.lang3.tuple.Pair;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Day09 {

    public Integer partOne(List<String> input) {
        List<Instruction> instructions = parseInstructions(input);

        Rope head = new RopeImpl(Pair.of(0, 0));
        Rope tail = new RopeImpl(Pair.of(0, 0));
        for (Instruction instruction : instructions) {
            for (int i = 0; i < instruction.getStepCount(); i++) {
                Pair<Integer, Integer> headCurrentPosition = head.getCurrentPosition();
                switch (instruction.getDirection()) {
                    case up: {
                        head.move(Pair.of(headCurrentPosition.getLeft(), headCurrentPosition.getRight() - 1));
                        break;
                    }
                    case down: {
                        head.move(Pair.of(headCurrentPosition.getLeft(), headCurrentPosition.getRight() + 1));
                        break;
                    }
                    case left: {
                        head.move(Pair.of(headCurrentPosition.getLeft() - 1, headCurrentPosition.getRight()));
                        break;
                    }
                    case right: {
                        head.move(Pair.of(headCurrentPosition.getLeft() + 1, headCurrentPosition.getRight()));
                        break;
                    }
                }
                tail.move(calcTailPosition(head, tail));
            }
        }
        tail.getPositionsHistory().add(tail.getCurrentPosition());
        Set<Pair<Integer, Integer>> tailUniqPosition = new HashSet<>(tail.getPositionsHistory());
        return tailUniqPosition.size();
    }

    public int partTwo(List<String> input) {
        return 0;
    }

    private List<Instruction> parseInstructions(List<String> input) {
        return input.stream().map(Instruction::new).collect(Collectors.toList());
    }

    private Pair<Integer, Integer> calcTailPosition(Rope head, Rope tail) {
        Pair<Integer, Integer> headPosition = head.getCurrentPosition();
        Pair<Integer, Integer> tailPosition = tail.getCurrentPosition();

        if (isNeighbor(headPosition, tailPosition)) {
            return tailPosition;
        }
        return head.getPrevPosition();
    }

    private boolean isNeighbor(Pair<Integer, Integer> headPosition, Pair<Integer, Integer> tailPosition) {
        return Math.abs(headPosition.getLeft() - tailPosition.getLeft()) <= 1 && Math.abs(headPosition.getRight() - tailPosition.getRight()) <= 1;
    }

}