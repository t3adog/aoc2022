package ru.keptelr.day10;

import org.apache.commons.lang3.Range;

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


    public void partTwo(List<String> input) {
        String[][] CRT = initCrt();

        List<CpuInstruction> cpuInstructions = input.stream().map(CpuInstruction::from).collect(Collectors.toList());

        int cycleCount = 1;
        int index = 0;
        int crtIndex = 0;
        for (CpuInstruction cpuInstruction : cpuInstructions) {
            int internalIndex = cpuInstruction.getCommand() == Command.noop ? 1 : 2;
            for (int i = 0; i < internalIndex; i++) {
                int y = index / 40;
                printInCRT(y, cycleCount, crtIndex, CRT);
                crtIndex++;
                index++;
                if (crtIndex == 40) {
                    crtIndex = 0;
                }
            }
            cycleCount += cpuInstruction.getCycleCount();

        }
        renderCRT(CRT);
    }

    private String[][] initCrt() {
        String crt[][] = new String[6][40];
        for (int y = 0; y < 6; y++) {
            for (int x = 0; x < 40; x++) {
                crt[y][x] = ".";
            }
        }
        return crt;
    }

    private void printInCRT(int y, int x, int crtIndex, String[][] CRT) {
        if (Range.between(x - 1, x + 1).contains(crtIndex)) {
            CRT[y][crtIndex] = "#";
        }
    }

    private void renderCRT(String[][] crt) {
        for (int y = 0; y < 6; y++) {
            for (int x = 0; x < 40; x++) {
                System.out.print(crt[y][x]);
            }
            System.out.println();
        }
    }

}