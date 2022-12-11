package ru.keptelr.day10;

import java.util.List;
import java.util.stream.Collectors;

public class Day10 {

    public Integer partOne(List<String> input) {
        List<CpuInstruction> cpuInstructions = input.stream().map(CpuInstruction::from).collect(Collectors.toList());

        int signalStrengthsSum = 0;
        int cycleCount = 1;
        int index = 0;
        List<Integer> necessaryIndicies = List.of(20, 60, 100, 140, 180, 220);
        for (CpuInstruction cpuInstruction : cpuInstructions) {
            int internalIndex = cpuInstruction.getCommand() == Command.noop ? 1 : 2;
            for (int i = 0; i < internalIndex; i++) {
                index++;
                if (necessaryIndicies.contains(index)) {
                    signalStrengthsSum += calcSignalStrengths(index, cycleCount);
                }
            }
            cycleCount += cpuInstruction.getCycleCount();
        }
        return signalStrengthsSum;
    }

    private Integer calcSignalStrengths(int index, int cycleCount) {
        return index * cycleCount;
    }


    public int partTwo(List<String> input) {
        return 0;
    }

}