package ru.keptelr.day09;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Day09 {

    public Integer partOne(List<String> input) {
        List<Instruction> instructions = parseInstructions(input);

        Rope head = new Rope(new Point(0, 0));
        Rope tail = new Rope(new Point(0, 0));
        for (Instruction instruction : instructions) {
            for (int i = 0; i < instruction.getStepCount(); i++) {
                head.handleInstruction(instruction.getDirection(), 1);
                if (tail.isNeighbor(head)) {
                    continue;
                }
                tail.move(head.getPrevPosition());
            }
        }
        return tail.getUniqPositionCount();
    }


    public int partTwo(List<String> input) {
        List<Instruction> instructions = parseInstructions(input);

        List<Rope> ropes = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            ropes.add(new Rope(new Point(0, 0)));
        }

        for (Instruction instruction : instructions) {
            for (int i = 0; i < instruction.getStepCount(); i++) {
                Rope head = ropes.get(0);

                head.handleInstruction(instruction.getDirection(), 1);

                for (int z = 1; z < ropes.size(); z++) {
                    Rope tail = ropes.get(z);
                    Rope preHead = ropes.get(z - 1);

                    Point tailPosition = tail.getCurrentPosition();
                    Point prevHeadPosition = preHead.getCurrentPosition();

                    List<Point> possiblePoints = new ArrayList<>();
                    if (tail.isNeighbor(preHead)) {
                        continue;
                    }

                    if (prevHeadPosition.getX() != tailPosition.getX() && prevHeadPosition.getY() != tailPosition.getY()) {
                        possiblePoints.add(new Point(tailPosition.getX() + 1, tailPosition.getY() + 1));
                        possiblePoints.add(new Point(tailPosition.getX() + 1, tailPosition.getY() - 1));
                        possiblePoints.add(new Point(tailPosition.getX() - 1, tailPosition.getY() + 1));
                        possiblePoints.add(new Point(tailPosition.getX() - 1, tailPosition.getY() - 1));
                    } else {
                        possiblePoints.add(new Point(tailPosition.getX() + 1, tailPosition.getY()));
                        possiblePoints.add(new Point(tailPosition.getX() - 1, tailPosition.getY()));
                        possiblePoints.add(new Point(tailPosition.getX(), tailPosition.getY() + 1));
                        possiblePoints.add(new Point(tailPosition.getX(), tailPosition.getY() - 1));
                    }

                    for (Point point : possiblePoints) {
                        if (preHead.isNeighbor(new Rope(point))) {
                            tail.move(point);
                            break;
                        }
                    }
                }
            }
        }

        return ropes.get(9).getUniqPositionCount();
    }

    private List<Instruction> parseInstructions(List<String> input) {
        return input.stream().map(Instruction::new).collect(Collectors.toList());
    }

}