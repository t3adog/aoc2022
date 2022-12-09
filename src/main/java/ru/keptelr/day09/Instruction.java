package ru.keptelr.day09;

import lombok.Data;

@Data
public class Instruction {

    private Direction direction;
    private Integer stepCount;

    public Instruction(String instructionStr) {
        switch (instructionStr.split(" ")[0]) {
            case "R": {
                this.direction = Direction.right;
                break;
            }
            case "U": {
                this.direction = Direction.up;
                break;
            }
            case "D": {
                this.direction = Direction.down;
                break;
            }
            case "L": {
                this.direction = Direction.left;
                break;
            }
        }
        this.stepCount = Integer.parseInt(instructionStr.split(" ")[1]);
    }
}
