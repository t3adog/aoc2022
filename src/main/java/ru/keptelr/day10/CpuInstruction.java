package ru.keptelr.day10;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
public class CpuInstruction {
    private Command command;
    private int cycleCount;

    public CpuInstruction(Command command, int cycleCount) {
        this.command = command;
        this.cycleCount = cycleCount;
    }

    public static CpuInstruction from(String line) {
        String[] splittedLine = line.split(" ");
        return new CpuInstruction(
                Command.valueOf(splittedLine[0]),
                splittedLine.length > 1 ? Integer.parseInt(splittedLine[1]) : 0
        );
    }
}
